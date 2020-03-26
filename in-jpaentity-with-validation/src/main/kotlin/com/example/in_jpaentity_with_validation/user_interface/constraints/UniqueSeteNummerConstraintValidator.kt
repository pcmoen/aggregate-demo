package com.example.in_jpaentity_with_validation.user_interface.constraints

import com.example.in_jpaentity_with_validation.user_interface.Sete
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueSeteNummerConstraintValidator : ConstraintValidator<UniqueSeteNummer?, List<Sete>> {
    override fun isValid(values: List<Sete>, context: ConstraintValidatorContext): Boolean {
        val duplicate = values.stream()
                .anyMatch { sete1: Sete ->
                    values.stream()
                            .anyMatch { sete2: Sete -> sete1 !== sete2 && sete1.nummer == sete2.nummer }
                }
        return !duplicate
    }
}
