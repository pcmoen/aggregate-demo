package com.example.demo.domain

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
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
        val storedVogn = vognRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

        storedVogn.update(vogn)


        return vognRepository.save(storedVogn)
    }
}
