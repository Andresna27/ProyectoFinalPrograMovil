package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyectofinal.databinding.ActivityRegistrarseBinding

class Registrarse : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistrarseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_registrarse)
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btnRegister.setOnClickListener{
            haceRegister();
        }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
    private fun haceRegister() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Log.d("Creando usuario", "Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Creando usuario", "Falló")
                    Toast.makeText(baseContext, "Falló", Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }
}