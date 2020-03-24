package com.example.demo.user_interface

import com.example.demo.domain.VognService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vogner")
class VognController(private val vognService: VognService) {
    @PostMapping
    fun addNewVogn(@RequestBody vogn: Vogn): Vogn {
        return vognService.addNewVogn(vogn.asDomain()).fromDomain()
    }

    @GetMapping("/{vognId}")
    fun getVogn(@PathVariable("vognId")  vognId: Long): ResponseEntity<Vogn> {
        return ResponseEntity.of(vognService.findVogn(vognId).map { it.fromDomain() })
    }

    @PutMapping("/{vognId}")
    fun uppdaterVogn(@PathVariable("vognId")  vognId: Long, @RequestBody vogn: Vogn): ResponseEntity<Vogn> {
        return ResponseEntity.ok(vognService.uppdaterVogn(vognId, vogn.asDomain()).fromDomain())
    }
}
