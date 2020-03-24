package com.example.demo.domain

import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
data class Vogn(
        val uuid: String = UUID.randomUUID().toString(),

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [ALL])
        var kupeer: List<Kupe>
){
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L
}
