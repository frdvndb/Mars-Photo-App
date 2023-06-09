package com.example.android.marsphotos.network

import com.squareup.moshi.Json

/**
 * Kelas data yang mendefinisikan foto mars,
 * dengan id dan URL gambar.
 * Nama properti dari kelas data digunakan oleh Moshi
 * untuk menyamakan pada nama dari nilai di JSON.
 */
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)