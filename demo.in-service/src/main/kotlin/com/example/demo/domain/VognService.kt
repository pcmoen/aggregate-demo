package com.example.demo.domain

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.transaction.Transactional
import kotlin.collections.ArrayList

@Service
class VognService(private val vognRepository: VognRepository) {
    fun addNewVogn(vogn: Vogn) {
        vognRepository.save(vogn)
    }

    fun findVogn(vognId: Long): Optional<Vogn> {
        return vognRepository.findById(vognId)
    }

    @Transactional
    fun uppdaterVogn(id: Long, vogn: Vogn): Vogn {
        val storedVogn = vognRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

        storedVogn.navn = vogn.navn


        // De som skal slettes storedVogn.kupeer.filter { kupe -> vogn.kupeer.none { kupe.uuid.equals(it.uuid) } }

        val (existingKupes, newKupes) = vogn.kupeer.partition { kupe -> storedVogn.kupeer.any { kupe.uuid == it.uuid } }

        val kupeToKeep = ArrayList<Kupe>()

        existingKupes.forEach { kupe ->
            run {
                val storedKupe: Kupe = storedVogn.kupeer.first { kupe.uuid == it.uuid }

                storedKupe.navn = kupe.navn

                val (existingSetes, newSetes) = kupe.seter.partition { sete -> storedKupe.seter.any { sete.uuid == it.uuid } }
                println("existingSetes = ${existingSetes.size}")
                println("newSetes = ${newSetes.size}")

                val seteToKeep = ArrayList<Sete>()

                existingSetes.forEach { sete ->
                    run {
                        val storedSete = storedKupe.seter.first { sete.uuid == it.uuid }

                        storedSete.navn = sete.navn

                        seteToKeep.add(storedSete)
                    }
                }

                seteToKeep.addAll(newSetes)

                storedKupe.seter = seteToKeep

                kupeToKeep.add(storedKupe)
            }
        }

        kupeToKeep.addAll(newKupes)

        storedVogn.kupeer = kupeToKeep

        return vognRepository.save(storedVogn)
    }
}
