package com.example.demo.domain

import java.util.UUID.randomUUID
import javax.persistence.*

@Entity
data class Kupe(
        val uuid: String = randomUUID().toString(),

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [CascadeType.ALL])
        var seter: List<Sete>)
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L
}