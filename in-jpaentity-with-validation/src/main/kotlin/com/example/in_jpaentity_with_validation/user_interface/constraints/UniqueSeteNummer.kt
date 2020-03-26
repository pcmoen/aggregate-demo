package com.example.in_jpaentity_with_validation.user_interface.constraints

import javax.validation.Constraint
import kotlin.reflect.KClass

@Constraint(validatedBy = [UniqueSeteNummerConstraintValidator::class])
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class UniqueSeteNummer(
        @Suppress("unused") val message: String = "Setene må ha unike nummer i en kupe",
        @Suppress("unused") val groups: Array<KClass<out Any>> = [],
        @Suppress("unused") val payload: Array<KClass<out Any>> = []
)
