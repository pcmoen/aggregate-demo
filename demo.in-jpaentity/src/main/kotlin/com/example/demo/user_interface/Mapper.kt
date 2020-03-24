package com.example.demo.user_interface

import java.util.*


fun uuid(): String {
    return UUID.randomUUID().toString()
}

fun Sete.asDomain(): com.example.demo.domain.Sete {
    return com.example.demo.domain.Sete(uuid ?: uuid(), navn)
}

fun Kupe.asDomain(): com.example.demo.domain.Kupe {
    return com.example.demo.domain.Kupe(uuid ?: uuid(), navn, seter.map { it.asDomain() })
}

fun Vogn.asDomain(): com.example.demo.domain.Vogn {
    return com.example.demo.domain.Vogn(uuid ?: uuid(), navn, kupeer.map { it.asDomain() })
}

fun com.example.demo.domain.Sete.fromDomain(): Sete {
    return Sete(uuid, navn)
}

fun com.example.demo.domain.Kupe.fromDomain(): Kupe {
    return Kupe(uuid, navn, seter.map { it.fromDomain() })
}

fun com.example.demo.domain.Vogn.fromDomain(): Vogn {
    return Vogn(uuid, navn, kupeer.map { it.fromDomain() })
}