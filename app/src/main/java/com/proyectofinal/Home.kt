package com.proyectofinal

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyectofinal.databinding.ActivityHomeBinding
import com.proyectofinal.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogoff.setOnClickListener{
            Firebase.auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()
        add.setOnClickListener {
            val intent = Intent(this, CreateCard::class.java)
            startActivity(intent)
        }
//        deleteAll.setOnClickListener {
//            DataObject.deleteAll()
//            GlobalScope.launch {
//                database.dao().deleteAll()
//            }
//            setRecycler()
//        }

        setRecycler()


    }

    fun setRecycler() {
        recycler_view.adapter = Adapter(DataObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}