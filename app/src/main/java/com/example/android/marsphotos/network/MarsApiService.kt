package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
/**
 * Deklarasi konstanta yang berisi nilai URL untuk
 * backend server foto mars.
 */
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Membangun objek Moshi dengan adapter factory Kotlin
 * yang digunakan Retrofit.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Objek Retrofit dengan Konverter Moshi.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * Interface publik untuk metode [getPhotos]
 */
interface MarsApiService {
    /**
     * Mengembalikan [List] di [MarsPhoto],
     * metode bisa dipanggil dari Coroutine.
     * Anotasi @GET mengindikasikan "photos"
     * titik akhir akan diminta dengan metode GET HTTP.
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

/**
 * Objek Api publik yang memperlihatkan
 * layanan Retrofit yang diinisialisasi Lazy.
 */
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}