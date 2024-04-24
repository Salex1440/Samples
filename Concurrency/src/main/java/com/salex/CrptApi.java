package com.salex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CrptApi {

    private final Semaphore semaphore;
    private final int requestLimit;
    private final Object lock = new Object();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final String POST_PATH = "https://ismp.crpt.ru/api/v3/lk/documents/create";
    private final AtomicInteger cnt;
    private final HttpClient httpClient;

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        Objects.requireNonNull(timeUnit);
        if (requestLimit <= 0) throw new IllegalArgumentException("requestLimit must be a positive number!");
        this.cnt = new AtomicInteger(requestLimit);
        this.requestLimit = requestLimit;
        this.semaphore = new Semaphore(requestLimit);
        this.httpClient = HttpClient.newBuilder()
            .build();
        executor.scheduleAtFixedRate(this::releaseSemaphore, 1, 1, timeUnit);
    }

    private void releaseSemaphore() {
        synchronized (lock) {
            System.out.println("Release semaphore. Time: " + LocalTime.now());
            int t = requestLimit - cnt.get();
            for (int i = 0; i < t; i++) {
                semaphore.release();
                cnt.getAndIncrement();
                System.out.println("--- " + Thread.currentThread().getName() + " release: " + cnt.get());
            }
        }
    }

    private void acquire() throws InterruptedException {
        semaphore.acquire();
        synchronized (lock) {
        }
        cnt.getAndDecrement();
        System.out.println(Thread.currentThread().getName() + " acquire: " + cnt.get());
    }

    public void create(Document document, String sign) throws InterruptedException, JsonProcessingException {
        acquire();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
        mapper.setDateFormat(df);
        String json = mapper.writeValueAsString(document);
        try {
            URI uri = new URI(POST_PATH);
            HttpRequest.BodyPublisher docBody = HttpRequest.BodyPublishers.ofString(json);
            HttpRequest.BodyPublisher signBody = HttpRequest.BodyPublishers.ofString(sign);
            HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.concat(docBody, signBody))
                .build();
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        executor.shutdown();
    }

    @Getter
    @AllArgsConstructor
    static class Document {
        private Description description;
        @JsonProperty("doc_id")
        private String docId;
        @JsonProperty("doc_status")
        private String docStatus;
        @JsonProperty("doc_type")
        private String docType;
        @JsonProperty("import_request")
        private boolean importRequest;
        @JsonProperty("owner_inn")
        private String ownerInn;
        @JsonProperty("participant_inn")
        private String participantInn;
        @JsonProperty("producer_inn")
        private String producerInn;
        @JsonProperty("production_date")
        private LocalDate productionDate;
        @JsonProperty("production_type")
        private String productionType;
        private List<Product> products;
        @JsonProperty("reg_date")
        private LocalDate regDate;
        @JsonProperty("reg_number")
        private String regNumber;
    }

    @Getter
    @AllArgsConstructor
    static class Description {
        private String participantInn;
    }

    @Getter
    @AllArgsConstructor
    static class Product {
        @JsonProperty("certificate_document")
        private String certificateDocument;
        @JsonProperty("certificate_document_date")
        private LocalDate certificateDocumentDate;
        @JsonProperty("certificate_document_number")
        private String certificateDocumentNumber;
        @JsonProperty("owner_inn")
        private String ownerInn;
        @JsonProperty("producer_inn")
        private String producerInn;
        @JsonProperty("production_date")
        private LocalDate productionDate;
        @JsonProperty("tnved_code")
        private String tnvedCode;
        @JsonProperty("uit_code")
        private String uitCode;
        @JsonProperty("uitu_code")
        private String uituCode;
    }

}
