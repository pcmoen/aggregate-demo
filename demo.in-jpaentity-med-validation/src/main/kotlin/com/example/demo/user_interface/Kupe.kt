package com.example.demo.user_interface

import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

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
