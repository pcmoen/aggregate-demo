package com.example.naive.user_interface

data class Vogn(
        val id: Long,
        val navn: String,
        val kupeer: List<Kupe>
)