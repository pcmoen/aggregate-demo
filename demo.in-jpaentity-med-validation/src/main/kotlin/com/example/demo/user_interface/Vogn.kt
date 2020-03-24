package com.example.demo.user_interface

import javax.validation.Valid
import javax.validation.constraints.NotEmpty

data class Vogn(
        @field:NotEmpty
        val navn: String,
        @field:NotEmpty
        @field:Valid
        @field:UniqueKupeNummer
        val kupeer: List<Kupe>
)