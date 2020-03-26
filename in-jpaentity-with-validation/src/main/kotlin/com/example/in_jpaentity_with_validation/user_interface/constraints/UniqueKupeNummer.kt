package com.example.in_jpaentity_with_validation.user_interface.constraints

import javax.validation.Constraint
import kotlin.reflect.KClass

@Constraint(validatedBy = [UniqueKupeNummerConstraintValidator::class])
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class UniqueKupeNummer(
        @Suppress("unused") val message: String = "Kupene må ha unike nummer i en vogn",
        @Suppress("unused") val groups: Array<KClass<out Any>> = [],
        @Suppress("unused") val payload: Array<KClass<out Any>> = []
)
