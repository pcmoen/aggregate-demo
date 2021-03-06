package com.example.in_jpaentity_with_validation.domain

import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
@Suppress("JpaObjectClassSignatureInspection")
data class Vogn(
        @Column(nullable = false)
        var navn: String,

        @OneToMany(cascade = [ALL])
        @JoinColumn(name = "vogn_id")
        var kupeer: List<Kupe>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("unused")
    val id: Long? = null

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
