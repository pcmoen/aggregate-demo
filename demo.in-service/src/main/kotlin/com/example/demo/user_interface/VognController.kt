package com.example.demo.user_interface

import com.example.demo.domain.VognService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

fun uuid(): String {
    return UUID.randomUUID().toString()
}

fun asDomain(sete: Sete): com.example.demo.domain.Sete {
    with(sete) {
        return com.example.demo.domain.Sete(uuid ?: uuid(), navn)
    }
}

fun asDomain(kupe: Kupe): com.example.demo.domain.Kupe {
    with(kupe) {
        return com.example.demo.domain.Kupe(uuid ?: uuid(), navn, seter.map { asDomain(it) })
    }
}

fun asDomain(vogn: Vogn): com.example.demo.domain.Vogn {
    with(vogn) {
        return com.example.demo.domain.Vogn(uuid ?: uuid(), navn, kupeer.map { asDomain(it) })
    }
}

fun fromDomain(sete: com.example.demo.domain.Sete): Sete {
    with(sete) {
        return Sete(uuid, navn)
    }
}

fun fromDomain(kupe: com.example.demo.domain.Kupe): Kupe {
    with(kupe) {
        return Kupe(uuid, navn, seter.map { fromDomain(it) })
    }
}

fun fromDomain(vogn: com.example.demo.domain.Vogn): Vogn {
    with(vogn) {
        return Vogn(uuid, navn, kupeer.map { fromDomain(it) })
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
        return ResponseEntity.ok(fromDomain(vognService.uppdaterVogn(vognId, asDomain(vogn))))
    }
}
