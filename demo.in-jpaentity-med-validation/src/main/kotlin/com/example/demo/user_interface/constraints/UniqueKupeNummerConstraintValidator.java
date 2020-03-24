package com.example.demo.user_interface.constraints;

import com.example.demo.user_interface.Kupe;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueKupeNummerConstraintValidator implements ConstraintValidator<UniqueKupeNummer, List<Kupe>> {
    @Override
    public boolean isValid(List<Kupe> values, ConstraintValidatorContext context) {
        boolean duplicate = values.stream()
                .anyMatch(kupe1 ->
                        values.stream()
                                .anyMatch(kupe2 -> kupe1 != kupe2 && kupe1.getNummer() == kupe2.getNummer())
                );
        return !duplicate;
    }
}