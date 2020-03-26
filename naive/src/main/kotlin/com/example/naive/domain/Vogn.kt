package com.example.naive.domain

import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
data class Vogn(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [ALL])
        var kupeer: List<Kupe>
)
