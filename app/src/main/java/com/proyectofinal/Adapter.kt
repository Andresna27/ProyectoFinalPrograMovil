package com.proyectofinal

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var priority = itemView.priority
        var layout = itemView.mylayout
        var dni = itemView.dni
        var placa = itemView.placa
        var name = itemView.name
        var phone = itemView.telefono
        var hora = itemView.hora
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when (data[position].priority.toLowerCase()) {
            "ocupado" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "libre" -> holder.layout.setBackgroundColor(Color.parseColor("#2bab11"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        holder.title.text = data[position].title
        holder.priority.text = data[position].priority
        holder.dni.text = data[position].dni
        holder.placa.text = data[position].placa
        holder.name.text = data[position].name
        holder.phone.text = data[position].phone
        holder.hora.text = data[position].hora
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}