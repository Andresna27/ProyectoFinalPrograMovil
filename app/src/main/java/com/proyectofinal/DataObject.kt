package com.proyectofinal

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(title: String, priority: String,dni: String,placa: String,name: String,phone: String, hora: String) {
        listdata.add(CardInfo(title, priority,dni,placa,name,phone, hora))
    }

    fun getAllData(): List<CardInfo> {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }

    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos:Int,title:String,priority:String,dni: String,placa: String,name: String,phone: String, hora: String)
    {
        listdata[pos].title=title
        listdata[pos].priority=priority
        listdata[pos].dni=dni
        listdata[pos].placa=placa
        listdata[pos].name=name
        listdata[pos].phone=phone
        listdata[pos].hora=hora
    }

}