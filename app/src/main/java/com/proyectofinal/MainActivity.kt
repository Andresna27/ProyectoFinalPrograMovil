package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        FirebaseApp.initializeApp(this)
//        auth = Firebase.auth
//
//        binding.

        var InicioSesion = findViewById(R.id.btn_iniciarSesion) as Button
        InicioSesion.setOnClickListener {

            val intent = Intent(this, com.proyectofinal.Bienvenida::class.java)
            startActivity(intent)

        }
        var Registrarse = findViewById(R.id.btn_registrarse) as Button
        Registrarse.setOnClickListener {

            val intent = Intent(this, com.proyectofinal.Registrarse::class.java)
            startActivity(intent)

        }
        var info = findViewById(R.id.btn_informacion) as Button
        info.setOnClickListener {

            val intent = Intent(this, com.proyectofinal.MasInformacion::class.java)
            startActivity(intent)

        }
        var contact = findViewById(R.id.btn_contacto) as Button
        contact.setOnClickListener {

            val intent = Intent(this, com.proyectofinal.Contacto::class.java)
            startActivity(intent)

        }

    }
}
