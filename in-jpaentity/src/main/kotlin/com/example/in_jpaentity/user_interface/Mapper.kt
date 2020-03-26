package com.example.in_jpaentity.user_interface

import java.util.*


fun uuid(): String {
    return UUID.randomUUID().toString()
}

fun Sete.asDomain(): com.example.in_jpaentity.domain.Sete {
    return com.example.in_jpaentity.domain.Sete(uuid ?: uuid(), navn)
}

fun Kupe.asDomain(): com.example.in_jpaentity.domain.Kupe {
    return com.example.in_jpaentity.domain.Kupe(uuid ?: uuid(), navn, seter.map { it.asDomain() })
}

fun Vogn.asDomain(): com.example.in_jpaentity.domain.Vogn {
    return com.example.in_jpaentity.domain.Vogn(uuid ?: uuid(), navn, kupeer.map { it.asDomain() })
}

fun com.example.in_jpaentity.domain.Sete.fromDomain(): Sete {
    return Sete(uuid, navn)
}

fun com.example.in_jpaentity.domain.Kupe.fromDomain(): Kupe {
    return Kupe(uuid, navn, seter.map { it.fromDomain() })
}

fun com.example.in_jpaentity.domain.Vogn.fromDomain(): Vogn {
    return Vogn(uuid, navn, kupeer.map { it.fromDomain() })
}