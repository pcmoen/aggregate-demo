package com.example.in_jpaentity_with_validation.user_interface


fun Sete.asDomain(): com.example.in_jpaentity_with_validation.domain.Sete {
        return com.example.in_jpaentity_with_validation.domain.Sete(nummer, navn)
}

fun Kupe.asDomain(): com.example.in_jpaentity_with_validation.domain.Kupe {
        return com.example.in_jpaentity_with_validation.domain.Kupe(nummer, navn, seter.map { it.asDomain() })
}

fun Vogn.asDomain(): com.example.in_jpaentity_with_validation.domain.Vogn {
        return com.example.in_jpaentity_with_validation.domain.Vogn(navn, kupeer.map { it.asDomain() })
}

fun com.example.in_jpaentity_with_validation.domain.Sete.fromDomain(): Sete {
        return Sete(nummer, navn)
}

fun com.example.in_jpaentity_with_validation.domain.Kupe.fromDomain(): Kupe {
        return Kupe(nummer, navn, seter.map { it.fromDomain() })
}

fun com.example.in_jpaentity_with_validation.domain.Vogn.fromDomain(): Vogn {
        return Vogn(navn, kupeer.map { it.fromDomain() })
}