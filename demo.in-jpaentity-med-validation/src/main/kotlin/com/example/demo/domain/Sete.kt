package com.example.demo.domain

import javax.persistence.*

@Entity
data class Sete(
        @Column(nullable = false)
        val nummer: Int,
        var navn: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    fun update(sete: Sete) {
        this.navn = sete.navn
    }
}