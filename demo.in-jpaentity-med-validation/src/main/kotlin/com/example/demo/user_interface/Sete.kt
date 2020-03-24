package com.example.demo.user_interface

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

data class Sete(
        @field:Positive
        val nummer: Int,
        @field:NotEmpty
        val navn: String
)