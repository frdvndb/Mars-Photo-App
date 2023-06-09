package com.example.android.marsphotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.marsphotos.databinding.FragmentOverviewBinding
import com.example.android.marsphotos.databinding.GridViewItemBinding

/**
 * Fragmen ini menunjukkan status transaksi layanan web foto Mars.
 */
class OverviewFragment : Fragment() {

    // Deklarasi variabel dengan nama viewModel yang
    // merupakan instance dari kelas OverviewViewModel.
    private val viewModel: OverviewViewModel by viewModels()

    /**
     * Inflates tata letak dengan Data Binding,
     * menyetel pemilik lifecycle ke OverviewFragment
     * untuk mengaktifkan Data Binding agar dapat mengamati
     * LiveData, dan menyiapkan RecyclerView dengan adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // Mengizinkan Data Binding untuk
        // mengamati LiveData dengan lifecycle Fragmen ini.
        binding.lifecycleOwner = this

        // Memberikan akses binding kepada OverviewViewModel
        binding.viewModel = viewModel

        // Inisialisasi Adapter RecyclerView ke objek
        // PhotoGridAdapter baru.
        binding.photosGrid.adapter = PhotoGridAdapter()

        return binding.root // Mengembalikan view root
    }
}