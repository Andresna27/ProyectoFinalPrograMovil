package com.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyectofinal.databinding.ActivityMainBinding

class IngresoDatos2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_ingreso_datos2)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}