package com.example.in_service.domain

import java.util.*
import javax.persistence.*

@Entity
data class Sete(
        val uuid: String = UUID.randomUUID().toString(),

        @Column(nullable = false)
        var navn: String
){
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L

}