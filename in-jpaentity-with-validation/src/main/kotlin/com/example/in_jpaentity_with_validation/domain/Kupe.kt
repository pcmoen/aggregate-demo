package com.example.in_jpaentity_with_validation.domain

import java.util.*
import javax.persistence.*

@Suppress("JpaObjectClassSignatureInspection")
@Entity
data class Kupe(
        @Column(nullable = false)
        val nummer: Int,

        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn
        var seter: List<Sete>) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("unused")
    val id: Long? = null

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