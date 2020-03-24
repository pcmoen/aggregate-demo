package com.example.demo.domain

import org.springframework.stereotype.Service
import java.util.*

@Service
class VognService(private val vognRepository: VognRepository) {
    fun addNewVogn(vogn: Vogn) {
        vognRepository.save(vogn)
    }

    fun findVogn(vognId: Long): Optional<Vogn> {
        return vognRepository.findById(vognId)
    }

    fun uppdaterVogn(vogn: Vogn): Vogn {
        return vognRepository.save(vogn)
    }
}
