package org.example.dto;

import org.example.annotation.PhoneNumberConstraint;
import org.springframework.validation.annotation.Validated;

@Validated
public class PhoneNumberDto {

    @PhoneNumberConstraint
    private String phone;

    public PhoneNumberDto() {}

    public PhoneNumberDto(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
