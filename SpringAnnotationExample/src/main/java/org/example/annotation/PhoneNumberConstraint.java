package org.example.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.analyzer.PhoneNumberConstraintAnalyzer;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberConstraintAnalyzer.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message() default "Invalid phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
