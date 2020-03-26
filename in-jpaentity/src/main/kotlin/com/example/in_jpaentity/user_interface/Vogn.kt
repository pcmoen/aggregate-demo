package com.example.in_jpaentity.user_interface

data class Vogn(
        val uuid: String?,
        val navn: String,
        val kupeer: List<Kupe>
)

data class Kupe(
        val uuid: String?,
        val navn: String,
        val seter: List<Sete>
)

data class Sete(
        val uuid: String?,
        val navn: String
)
