package com.example.in_jpaentity_with_validation.user_interface

import com.example.in_jpaentity_with_validation.user_interface.constraints.UniqueKupeNummer
import com.example.in_jpaentity_with_validation.user_interface.constraints.UniqueSeteNummer
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

data class Vogn(
        @field:NotEmpty
        val navn: String,
        @field:NotEmpty
        @field:Valid
        @field:UniqueKupeNummer
        val kupeer: List<Kupe>
)

data class Kupe(
        @field:Positive
        val nummer: Int,
        @field:NotEmpty
        val navn: String,
        @field:NotEmpty
        @field:Valid
        @field:UniqueSeteNummer
        val seter: List<Sete>
)

data class Sete(
        @field:Positive
        val nummer: Int,
        @field:NotEmpty
        val navn: String
)