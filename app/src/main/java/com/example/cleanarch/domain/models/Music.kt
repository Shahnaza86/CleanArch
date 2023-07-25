package com.example.cleanarch.domain.models

import java.io.Serializable

data class Music(
    val id: Int,
    val name: String,
    val perfomer: String,
    val duration: String
) : Serializable