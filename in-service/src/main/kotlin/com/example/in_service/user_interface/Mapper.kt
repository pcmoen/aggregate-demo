package com.example.in_service.user_interface

import java.util.*


fun uuid(): String {
    return UUID.randomUUID().toString()
}

fun Sete.asDomain(): com.example.in_service.domain.Sete {
    return com.example.in_service.domain.Sete(uuid ?: uuid(), navn)
}

fun Kupe.asDomain(): com.example.in_service.domain.Kupe {
    return com.example.in_service.domain.Kupe(uuid ?: uuid(), navn, seter.map { it.asDomain() })
}

fun Vogn.asDomain(): com.example.in_service.domain.Vogn {
    return com.example.in_service.domain.Vogn(uuid ?: uuid(), navn, kupeer.map { it.asDomain() })
}

fun com.example.in_service.domain.Sete.fromDomain(): Sete {
    return Sete(uuid, navn)
}

fun com.example.in_service.domain.Kupe.fromDomain(): Kupe {
    return Kupe(uuid, navn, seter.map { it.fromDomain() })
}

fun com.example.in_service.domain.Vogn.fromDomain(): Vogn {
    return Vogn(uuid, navn, kupeer.map { it.fromDomain() })
}