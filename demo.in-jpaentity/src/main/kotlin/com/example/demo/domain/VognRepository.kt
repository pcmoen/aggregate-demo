package com.example.demo.domain

import org.springframework.data.jpa.repository.JpaRepository

interface VognRepository : JpaRepository<Vogn, Long>
