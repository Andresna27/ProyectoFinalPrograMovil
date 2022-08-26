package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.proyectofinal.databinding.ActivityMasInformacionBinding

class MasInformacion : AppCompatActivity() {
    private lateinit var binding: ActivityMasInformacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var volver = findViewById(R.id.btn_volverInformacion) as Button

        volver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}