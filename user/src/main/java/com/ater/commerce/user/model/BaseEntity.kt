package com.ater.commerce.user.model

import java.time.LocalDateTime

data class BaseEntity (
    val createdDate: LocalDateTime? = null,
    val updatedDate: LocalDateTime? = null,
){
}