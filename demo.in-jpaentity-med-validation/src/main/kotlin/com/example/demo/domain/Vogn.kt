package com.example.demo.domain

import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
data class Vogn(
        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [ALL])
        var kupeer: List<Kupe>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    fun update(vogn: Vogn) {
        this.navn = vogn.navn

        val (existingKupes, newKupes) = vogn.kupeer.partition { kupe -> this.kupeer.any { kupe.nummer == it.nummer } }

        val kupeToKeep = ArrayList<Kupe>()

        existingKupes.forEach { kupe ->
            run {
                val storedKupe: Kupe = this.kupeer.first { kupe.nummer == it.nummer }

                storedKupe.update(kupe)


                kupeToKeep.add(storedKupe)
            }
        }

        kupeToKeep.addAll(newKupes)

        this.kupeer = kupeToKeep
    }
}
