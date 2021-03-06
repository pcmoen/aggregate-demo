package com.example.in_jpaentity.domain

import java.util.ArrayList
import java.util.UUID.randomUUID
import javax.persistence.*

@Entity
data class Kupe(
        val uuid: String = randomUUID().toString(),

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [CascadeType.ALL])
        var seter: List<Sete>) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    fun update(kupe: Kupe) {
        this.navn = kupe.navn

        val (existing, new) = kupe.seter.partition { sete -> this.seter.any { sete.uuid == it.uuid } }

        val seteToKeep = ArrayList<Sete>()

        existing.forEach { sete ->
            run {
                val storedSete = this.seter.first { sete.uuid == it.uuid }

                storedSete.update(sete)

                seteToKeep.add(storedSete)
            }
        }

        seteToKeep.addAll(new)

        this.seter = seteToKeep
    }
}