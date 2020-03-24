package com.example.demo.user_interface.constraints;

import com.example.demo.user_interface.Sete;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueSeteNummerConstraintValidator implements ConstraintValidator<UniqueSeteNummer, List<Sete>> {
    @Override
    public boolean isValid(List<Sete> values, ConstraintValidatorContext context) {
        boolean duplicate = values.stream()
                .anyMatch(sete1 ->
                        values.stream()
                                .anyMatch(sete2 -> sete1 != sete2 && sete1.getNummer() == sete2.getNummer())
                );
        return !duplicate;
    }
}