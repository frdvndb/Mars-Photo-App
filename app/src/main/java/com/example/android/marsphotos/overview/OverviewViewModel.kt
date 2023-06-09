package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

/**
 * [ViewModel] yang dilampirkan ke [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // MutableLiveData internal yang menyimpan
    // status permintaan terbaru.
    private val _status = MutableLiveData<MarsApiStatus>()

    // LiveData eksternal yang tidak dapat
    // diubah untuk status permintaan.
    val status: LiveData<MarsApiStatus> = _status

    // MutableLiveData internal yang menyimpan
    // daftar foto mars terbaru.
    private val _photos = MutableLiveData<List<MarsPhoto>>()

    // LiveData eksternal yang tidak dapat
    // diubah untuk daftar foto mars.
    val photos: LiveData<List<MarsPhoto>> = _photos

    /**
     * Panggil getMarsPhotos() di init agar
     * dapat segera menampilkan status.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Mendapatkan informasi foto Mars dari layanan Mars API
     * Retrofit dan memperbarui [MarsPhoto] [Daftar] [LiveData].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}