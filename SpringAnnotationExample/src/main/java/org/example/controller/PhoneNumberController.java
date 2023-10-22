package org.example.controller;

import org.example.dto.PhoneNumberDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PhoneNumberController {

    private PhoneNumberDto phone;

    @PostMapping("phone")
    public PhoneNumberDto setPhone(@Validated PhoneNumberDto phone) {
        this.phone = phone;
        return phone;
    }

}
