package com.example.android.marsphotos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity menyetel tampilan konten activity_main,
 * kontainer fragmen yang berisi overviewFragment.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}