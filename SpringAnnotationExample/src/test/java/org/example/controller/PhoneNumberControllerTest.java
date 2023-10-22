package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.example.dto.PhoneNumberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneNumberControllerTest extends TestCase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test()
        throws Exception {
        String number = "79876543210";
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
                .post("/phone")
                .accept(MediaType.APPLICATION_JSON)
                .param("phone", number))
            .andReturn();
        MockHttpServletResponse response = result.getResponse();

        byte[] content = response.getContentAsByteArray();

        ObjectMapper objectMapper = new ObjectMapper();
        PhoneNumberDto numberDto = objectMapper.readValue(content, PhoneNumberDto.class);
        assertEquals(number, numberDto.getPhone());
        assertEquals(200, response.getStatus());
    }

}