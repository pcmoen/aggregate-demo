package com.example.in_jpaentity_with_validation.domain

import javax.persistence.*

@Suppress("JpaObjectClassSignatureInspection")
@Entity
data class Sete(
        @Column(nullable = false)
        val nummer: Int,
        var navn: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("unused")
    val id: Long? = null

    fun update(sete: Sete) {
        this.navn = sete.navn
    }
}