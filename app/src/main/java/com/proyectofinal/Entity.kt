package com.proyectofinal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "To_Do")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String,
    var dni:String,
    var placa:String,
    var name:String,
    var phone:String,
    var hora:String
)