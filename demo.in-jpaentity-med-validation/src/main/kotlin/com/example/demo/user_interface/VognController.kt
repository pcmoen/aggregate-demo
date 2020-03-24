package com.example.demo.user_interface

import com.example.demo.domain.NoSuchVognException
import com.example.demo.domain.VognService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

fun asDomain(sete: Sete): com.example.demo.domain.Sete {
    with(sete) {
        return com.example.demo.domain.Sete(nummer, navn)
    }
}

fun asDomain(kupe: Kupe): com.example.demo.domain.Kupe {
    with(kupe) {
        return com.example.demo.domain.Kupe(nummer, navn, seter.map { asDomain(it) })
    }
}

fun asDomain(vogn: Vogn): com.example.demo.domain.Vogn {
    with(vogn) {
        return com.example.demo.domain.Vogn(navn, kupeer.map { asDomain(it) })
    }
}

fun fromDomain(sete: com.example.demo.domain.Sete): Sete {
    with(sete) {
        return Sete(nummer, navn)
    }
}

fun fromDomain(kupe: com.example.demo.domain.Kupe): Kupe {
    with(kupe) {
        return Kupe(nummer, navn, seter.map { fromDomain(it) })
    }
}

fun fromDomain(vogn: com.example.demo.domain.Vogn): Vogn {
    with(vogn) {
        return Vogn(navn, kupeer.map { fromDomain(it) })
    }
}

@RestController
@RequestMapping("/vogner")
@Validated
class VognController(private val vognService: VognService) {
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Ingen vogn funnet")
    @ExceptionHandler(value = [NoSuchVognException::class ])
    fun noSuchVognException() {
    }

    @PostMapping
    @Valid
    fun addNewVogn(@Valid @RequestBody vogn: Vogn): Vogn {
        return fromDomain(vognService.addNewVogn(asDomain(vogn)))
    }

    @GetMapping("/{vognId}")
    @Valid
    fun getVogn(@PathVariable("vognId")  vognId: Long): ResponseEntity<Vogn> {
        return ResponseEntity.of(vognService.findVogn(vognId).map { fromDomain(it) })
    }

    @PutMapping("/{vognId}")
    @Valid
    fun uppdaterVogn(@PathVariable("vognId")  vognId: Long, @Valid @RequestBody vogn: Vogn): ResponseEntity<Vogn> {
        return ResponseEntity.ok(fromDomain(vognService.uppdaterVogn(vognId, asDomain(vogn))))
    }
}
