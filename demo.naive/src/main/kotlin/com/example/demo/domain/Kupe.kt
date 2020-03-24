package com.example.demo.domain

import javax.persistence.*

@Entity
data class Kupe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val navn: String,

        @OneToMany(cascade = [CascadeType.ALL])
        val seter: List<Sete>
)
