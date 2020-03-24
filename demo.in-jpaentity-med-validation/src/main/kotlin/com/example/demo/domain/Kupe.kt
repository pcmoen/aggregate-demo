package com.example.demo.domain

import java.util.*
import javax.persistence.*

@Entity
data class Kupe(
        @Column(nullable = false)
        val nummer: Int,

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [CascadeType.ALL])
        var seter: List<Sete>) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    fun update(kupe: Kupe) {
        this.navn = kupe.navn

        val (existing, new) = kupe.seter.partition { sete -> this.seter.any { sete.nummer == it.nummer } }

        val seteToKeep = ArrayList<Sete>()

        existing.forEach { sete ->
            run {
                val storedSete = this.seter.first { sete.nummer == it.nummer }

                storedSete.update(sete)

                seteToKeep.add(storedSete)
            }
        }

        seteToKeep.addAll(new)

        this.seter = seteToKeep
    }
}