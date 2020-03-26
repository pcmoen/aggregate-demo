package com.example.in_jpaentity_with_validation.user_interface

import com.example.in_jpaentity_with_validation.domain.NoSuchVognException
import com.example.in_jpaentity_with_validation.domain.VognService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
        return vognService.addNewVogn(vogn.asDomain()).fromDomain()
    }

    @GetMapping("/{vognId}")
    @Valid
    fun getVogn(@PathVariable("vognId")  vognId: Long): ResponseEntity<Vogn> {
        return ResponseEntity.of(vognService.findVogn(vognId).map { it.fromDomain() })
    }

    @PutMapping("/{vognId}")
    @Valid
    fun uppdaterVogn(@PathVariable("vognId")  vognId: Long, @Valid @RequestBody vogn: Vogn): ResponseEntity<Vogn> {
        return ResponseEntity.ok(vognService.uppdaterVogn(vognId, vogn.asDomain()).fromDomain())
    }
}
