package org.example.analyzer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.annotation.PhoneNumberConstraint;

public class PhoneNumberConstraintAnalyzer implements ConstraintValidator<PhoneNumberConstraint, String> {
    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null && phoneNumber.startsWith("7") && phoneNumber.length() == 11;
    }
}
