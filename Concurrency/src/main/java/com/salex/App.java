package com.salex;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException, JsonProcessingException {
        CrptApi api = new CrptApi(TimeUnit.SECONDS, 100);
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        String participantInn1 = "participantInn";
        CrptApi.Description description = new CrptApi.Description(participantInn1);
        String docId = "docId";
        String docStatus = "docStatus";
        String docType = "docType";
        boolean importRequest = true;
        String ownerInn = "ownerInn";
        String participantInn = "participantInn";
        String producerInn = "producerInn";
        LocalDate productionDate = LocalDate.now();
        String productionType = "productionType";
        List<CrptApi.Product> products = new ArrayList<>();
        String certificateDocument = "certificateDocument";
        LocalDate certificateDocumentDate = LocalDate.now();
        String certificateDocumentNumber = "certificateDocumentNumber";
        String tnvedCode = "tnvedCode";
        String uitCode = "uitCode";
        String uituCode = "uituCode";
        CrptApi.Product product = new CrptApi.Product(certificateDocument, certificateDocumentDate, certificateDocumentNumber,
            ownerInn, producerInn, productionDate, tnvedCode, uitCode, uituCode);
        products.add(product);
        LocalDate regDate = LocalDate.now();
        String regNumber = "regNumber";
        CrptApi.Document document = new CrptApi.Document(description, docId, docStatus, docType, importRequest, ownerInn,
            participantInn, producerInn, productionDate, productionType, products, regDate, regNumber);
        String sign = "sign";
        api.create(document, sign);
//        List<Future<?>> futures = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            Future<?> f = executorService.submit(() -> {
//                try {
//
//                    api.create();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            futures.add(f);
//        }
//        for (Future<?> f : futures) {
//            Object o = f.get();
//        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " millis");
        executorService.shutdown();
        api.shutdown();
    }
}
