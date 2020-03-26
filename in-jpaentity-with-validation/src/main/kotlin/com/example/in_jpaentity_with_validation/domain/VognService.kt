package com.example.in_jpaentity_with_validation.domain

import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class VognService(private val vognRepository: VognRepository) {
    fun addNewVogn(vogn: Vogn): Vogn {
        return vognRepository.save(vogn)
    }

    fun findVogn(vognId: Long): Optional<Vogn> {
        return vognRepository.findById(vognId)
    }

    @Transactional
    fun uppdaterVogn(id: Long, vogn: Vogn): Vogn {
        val storedVogn = vognRepository.findById(id).orElseThrow { NoSuchVognException() }

        storedVogn.update(vogn)

        return storedVogn
    }
}
