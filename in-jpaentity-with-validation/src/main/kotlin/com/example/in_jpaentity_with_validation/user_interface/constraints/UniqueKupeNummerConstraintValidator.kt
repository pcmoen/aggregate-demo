package com.example.in_jpaentity_with_validation.user_interface.constraints

import com.example.in_jpaentity_with_validation.user_interface.Kupe
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueKupeNummerConstraintValidator : ConstraintValidator<UniqueKupeNummer?, List<Kupe>> {
    override fun isValid(values: List<Kupe>, context: ConstraintValidatorContext): Boolean {
        val duplicate = values.stream()
                .anyMatch { kupe1: Kupe ->
                    values.stream()
                            .anyMatch { kupe2: Kupe -> kupe1 !== kupe2 && kupe1.nummer == kupe2.nummer }
                }
        return !duplicate
    }
}
