package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.proyectofinal.databinding.ActivityContactoBinding

class Contacto : AppCompatActivity() {
    private lateinit var binding: ActivityContactoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var volver = findViewById(R.id.btn_volverContacto) as Button
        volver.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}