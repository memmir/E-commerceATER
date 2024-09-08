package com.ater.commerce.user.model

import jakarta.persistence.*

@Entity
@Table(name = "\"user\"")
data class User2(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? =null,
    val mail: String,
    val firstName: String,
    val lastName: String,
    val middleName: String
) {
}