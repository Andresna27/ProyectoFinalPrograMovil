package com.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_create_card.create_dni
import kotlinx.android.synthetic.main.activity_create_card.create_name
import kotlinx.android.synthetic.main.activity_create_card.create_phone
import kotlinx.android.synthetic.main.activity_create_card.create_placa
import kotlinx.android.synthetic.main.activity_create_card.create_title
import kotlinx.android.synthetic.main.activity_create_card.etTime
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase

    lateinit var option : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        var disponibilidad = ""
        etTime.setOnClickListener{ showTimePickerDialog()}
        option = findViewById(R.id.create_priority) as Spinner

        val options = arrayOf("Selecciona la disponibilidad", "Libre", "Ocupado")

        option.adapter = ArrayAdapter<String>(this, R.layout.spinner_item_disponibilidad, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                disponibilidad = options.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()
        save_button.setOnClickListener {
            if(disponibilidad != "Ocupado" && disponibilidad != "Selecciona la disponibilidad") {
                if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && disponibilidad.trim { it <= ' ' }.isNotEmpty()
                    && disponibilidad != "Selecciona la disponibilidad"
                    && disponibilidad != "Ocupado"
                    && etTime.text.toString().trim { it <= ' ' }.isNotEmpty()
                ) {
                    var title = "Espacio "+ create_title.getText().toString()
                    var dni = "-"
                    var placa = "-"
                    var name = "-"
                    var phone = "-"
                    var disponibilidad = disponibilidad
                    var hora = "Hora inicio: "+etTime.getText().toString()
                    DataObject.setData(title, disponibilidad,dni,placa,name,phone, hora)
                    GlobalScope.launch {
                        database.dao().insertTask(Entity(0, title, disponibilidad,dni,placa,name,phone, hora))
                    }
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }
            } else {
                if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && disponibilidad.trim { it <= ' ' }.isNotEmpty()
                    && disponibilidad != "Selecciona la disponibilidad"
                    && create_dni.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && create_placa.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && create_name.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && create_phone.text.toString().trim { it <= ' ' }.isNotEmpty()
                    && etTime.text.toString().trim { it <= ' ' }.isNotEmpty()
                ) {

                    var title = "Espacio "+ create_title.getText().toString()
                    var dni = "Cédula: "+ create_dni.getText().toString()
                    var placa = "Placa: "+ create_placa.getText().toString()
                    var name = "Nombre: "+ create_name.getText().toString()
                    var phone = "Teléfono: "+ create_phone.getText().toString()
                    var disponibilidad = disponibilidad
                    var hora = "Hora inicio: "+etTime.getText().toString()
                    DataObject.setData(title, disponibilidad,dni,placa,name,phone, hora)
                    GlobalScope.launch {
                        database.dao().insertTask(Entity(0, title, disponibilidad,dni,placa,name,phone, hora))

                    }
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }
            }



            }

    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }
    private fun onTimeSelected(time:String){
    etTime.setText(time)
    }
}