package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyectofinal.databinding.ActivityBienvenidaBinding
import com.proyectofinal.databinding.ActivityMainBinding

class Bienvenida : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityBienvenidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bienvenida)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener{
            haceLogin();
        }

//        var Reserva = findViewById(R.id.btn_register) as Button
//        Reserva.setOnClickListener {
//
//            val intent = Intent(this, IngresoDatos2::class.java)
//            startActivity(intent)
//
//        }
    }



    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }

    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Autenticando", "Falló")
                    Toast.makeText(baseContext, "Falló", Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }
}