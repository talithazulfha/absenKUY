package com.example.absenkuy.data.response

data class HomeResponse(
    val data: List<Any>, // Sesuaikan dengan struktur data dari API
    val message: String,
    val success: Boolean
)
