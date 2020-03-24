package com.example.demo.user_interface

import com.example.demo.domain.VognService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

fun asDomain(sete: Sete): com.example.demo.domain.Sete {
    with(sete) {
        return com.example.demo.domain.Sete(id, navn)
    }
}

fun asDomain(kupe: Kupe): com.example.demo.domain.Kupe {
    with(kupe) {
        return com.example.demo.domain.Kupe(id, navn, seter.map { asDomain(it) })
    }
}

fun asDomain(vogn: Vogn): com.example.demo.domain.Vogn {
    with(vogn) {
        return com.example.demo.domain.Vogn(id, navn, kupeer.map { asDomain(it) })
    }
}

fun fromDomain(sete: com.example.demo.domain.Sete): Sete {
    with(sete) {
        return Sete(id, navn)
    }
}

fun fromDomain(kupe: com.example.demo.domain.Kupe): Kupe {
    with(kupe) {
        return Kupe(id, navn, seter.map { fromDomain(it) })
    }
}

fun fromDomain(vogn: com.example.demo.domain.Vogn): Vogn {
    with(vogn) {
        return Vogn(id, navn, kupeer.map { fromDomain(it) })
    }
}

@RestController
@RequestMapping("/vogner")
class VognController(private val vognService: VognService) {
    @PostMapping
    fun addNewVogn(@RequestBody vogn: Vogn) {
        vognService.addNewVogn(asDomain(vogn))
    }

    @GetMapping("/{vognId}")
    fun getVogn(@PathVariable("vognId")  vognId: Long): ResponseEntity<Vogn> {
        return ResponseEntity.of(vognService.findVogn(vognId).map { fromDomain(it) })
    }

    @PutMapping("/{vognId}")
    fun uppdaterVogn(@PathVariable("vognId")  vognId: Long, @RequestBody vogn: Vogn): ResponseEntity<Vogn> {
        if (vognId != vogn.id) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Vogn id må være lik id")
        }

        return ResponseEntity.ok(fromDomain(vognService.uppdaterVogn(asDomain(vogn))))
    }
}
