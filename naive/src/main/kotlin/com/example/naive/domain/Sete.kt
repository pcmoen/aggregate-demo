package com.example.naive.domain

import javax.persistence.*

@Entity
data class Sete(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val navn: String
)