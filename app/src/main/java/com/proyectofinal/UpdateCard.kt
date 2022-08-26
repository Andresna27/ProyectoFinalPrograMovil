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
    import kotlinx.android.synthetic.main.activity_update_card.*
    import kotlinx.android.synthetic.main.activity_update_card.create_dni
    import kotlinx.android.synthetic.main.activity_update_card.create_name
    import kotlinx.android.synthetic.main.activity_update_card.create_phone
    import kotlinx.android.synthetic.main.activity_update_card.create_placa
    import kotlinx.android.synthetic.main.activity_update_card.create_priority
    import kotlinx.android.synthetic.main.activity_update_card.create_title
    import kotlinx.android.synthetic.main.activity_update_card.etTime
    import kotlinx.coroutines.GlobalScope
    import kotlinx.coroutines.launch

    class UpdateCard : AppCompatActivity() {
        private lateinit var database: myDatabase
        lateinit var option : Spinner
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_update_card)
            var disponibilidad = ""
            var ocupado = false
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
            val pos = intent.getIntExtra("id", -1)
            if (pos != -1) {

                val title = DataObject.getData(pos).title
                var dni = DataObject.getData(pos).dni
                var placa = DataObject.getData(pos).placa
                var name = DataObject.getData(pos).name
                var phone = DataObject.getData(pos).phone
                val hora = DataObject.getData(pos).hora
                val nPhone = phone.replace("Teléfono: ","")
                val nName = name.replace("Nombre: ","")
                val nPlaca = placa.replace("Placa: ","")
                val nDni = dni.replace("Cédula: ","")
                val nTitle = title.replace("Espacio ","")
                val nHora = hora.replace("Hora inicio: ","")
                var disp = DataObject.getData(pos).priority
                if (disp == "Libre") {
                    create_title.setText(nTitle)
                    create_priority.setSelection(1)
                    create_dni.setText("")
                    create_placa.setText("")
                    create_name.setText("")
                    create_phone.setText("")
                    etTime.setText(nHora)
                } else {
                    create_title.setText(nTitle)
                    create_priority.setSelection(2)
                    create_dni.setText(nDni)
                    create_placa.setText(nPlaca)
                    create_name.setText(nName)
                    create_phone.setText(nPhone)
                    etTime.setText(nHora)

                }

                delete_button.setOnClickListener {
                    DataObject.deleteData(pos)
                    GlobalScope.launch {
                        database.dao().deleteTask(
                            Entity(
                                pos + 1,
                                create_title.text.toString(),
                                disponibilidad,
                                create_dni.text.toString(),
                                create_placa.text.toString(),
                                create_name.text.toString(),
                                create_phone.text.toString(),
                                etTime.text.toString()
                            )
                        )
                    }
                    myIntent()
                }

                update_button.setOnClickListener {

                    if(disponibilidad != "Ocupado")
                    {
                        if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                            && disponibilidad.trim { it <= ' ' }.isNotEmpty()
                            && disponibilidad != "Selecciona la disponibilidad"
                            && disponibilidad != "Ocupado"
                            && etTime.text.toString().trim { it <= ' ' }.isNotEmpty()
                        ) {
                            if (disponibilidad == "Libre") {
                                DataObject.updateData(
                                    pos,
                                    create_title.text.toString(),
                                    disponibilidad,
                                    "-",
                                    "-",
                                    "-",
                                    "-",
                                    "Hora inicio: "+etTime.text.toString()
                                )
                                ocupado = false
                            }
                            }
                        } else {
                            if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                                && disponibilidad.trim { it <= ' ' }.isNotEmpty()
                                && disponibilidad == "Ocupado"
                                && create_dni.text.toString().trim { it <= ' ' }.isNotEmpty()
                                && create_placa.text.toString().trim { it <= ' ' }.isNotEmpty()
                                && create_name.text.toString().trim { it <= ' ' }.isNotEmpty()
                                && create_phone.text.toString().trim { it <= ' ' }.isNotEmpty()
                                && etTime.text.toString().trim { it <= ' ' }.isNotEmpty()
                            ) {
                                DataObject.updateData(
                                    pos,
                                    "Espacio "+create_title.text.toString(),
                                    disponibilidad,
                                    "Cédula: "+create_dni.text.toString(),
                                    "Placa: "+create_placa.text.toString(),
                                    "Nombre: "+create_name.text.toString(),
                                    "Teléfono: "+create_phone.text.toString(),
                                    "Hora inicio: "+etTime.text.toString()
                                )
                                ocupado = true
                            }
                        }

                        if (disponibilidad == "Libre") {
                            GlobalScope.launch {
                                database.dao().updateTask(
                                    Entity(
                                        pos + 1,
                                        create_title.text.toString(),
                                        disponibilidad,
                                        "-",
                                        "-",
                                        "-",
                                        "-",
                                        "Hora inicio: "+etTime.text.toString()
                                    )
                                )
                            }
                            myIntent()
                        } else if(ocupado) {
                            GlobalScope.launch {
                                database.dao().updateTask(
                                    Entity(
                                        pos + 1,
                                        "Espacio "+create_title.text.toString(),
                                        disponibilidad,
                                        "Cédula: "+create_dni.text.toString(),
                                        "Placa: "+create_placa.text.toString(),
                                        "Nombre: "+create_name.text.toString(),
                                        "Teléfono: "+create_phone.text.toString(),
                                        "Hora inicio: "+etTime.text.toString()
                                    )
                                )
                            }
                            myIntent()
                        }


                }
            }
        }
        fun myIntent() {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        private fun showTimePickerDialog() {

            val timePicker = TimePickerFragment {onTimeSelected(it)}

            timePicker.show(supportFragmentManager, "time")

        }
        private fun onTimeSelected(time:String){

            etTime.setText(time)
        }

    }