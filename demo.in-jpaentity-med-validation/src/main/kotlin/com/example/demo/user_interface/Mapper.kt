package com.example.demo.user_interface


fun Sete.asDomain(): com.example.demo.domain.Sete {
        return com.example.demo.domain.Sete(nummer, navn)
}

fun Kupe.asDomain(): com.example.demo.domain.Kupe {
        return com.example.demo.domain.Kupe(nummer, navn, seter.map { it.asDomain() })
}

fun Vogn.asDomain(): com.example.demo.domain.Vogn {
        return com.example.demo.domain.Vogn(navn, kupeer.map { it.asDomain() })
}

fun com.example.demo.domain.Sete.fromDomain(): Sete {
        return Sete(nummer, navn)
}

fun com.example.demo.domain.Kupe.fromDomain(): Kupe {
        return Kupe(nummer, navn, seter.map { it.fromDomain() })
}

fun com.example.demo.domain.Vogn.fromDomain(): Vogn {
        return Vogn(navn, kupeer.map { it.fromDomain() })
}