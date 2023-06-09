package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

/**
 * Kelas ini mengimplementasikan [RecyclerView] [ListAdapter]
 * yang menggunakan Data Binding untuk menyajikan data [List],
 * termasuk menghitung perbedaan antar list.
 */
class PhotoGridAdapter : ListAdapter<MarsPhoto,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    /**
     * Konstruktor MarsPhotosViewHolder mengambil variabel
     * binding dari GridViewItem terkait, yang memberinya
     * akses ke informasi [MarsPhoto].
     */
    class MarsPhotoViewHolder(private var binding:
                              GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto

            // Memaksa data binding untuk segera dieksekusi,
            // yang memungkinkan RecyclerView melakukan
            // pengukuran ukuran tampilan yang benar.
            binding.executePendingBindings()
        }
    }

    /**
     * Mengizinkan RecyclerView untuk menentukan
     * item mana yang telah berubah saat [List]
     * dari [MarsPhoto] telah diperbarui.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    /**
     * Buat tampilan item [RecyclerView] baru
     * (dipanggil oleh layout manager).
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        return PhotoGridAdapter.MarsPhotoViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Mengganti konten tampilan
     * (dipanggil oleh layout manager).
     */
    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}