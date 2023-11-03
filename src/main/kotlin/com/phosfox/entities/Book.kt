package com.phosfox.entities

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class Book (
    @KomapperId @KomapperAutoIncrement
    val id: Int = 0,
    val isbn: String,
    val title: String,
    @KomapperVersion
    val version: Int = 0,
    @KomapperCreatedAt
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @KomapperUpdatedAt
    val updatedAt: LocalDateTime = LocalDateTime.now()
)