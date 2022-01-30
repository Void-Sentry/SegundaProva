package com.example.segundaprova.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.Listar
import com.example.segundaprova.ListarDirections
import com.example.segundaprova.R
import com.example.segundaprova.data.model.atividadeFisica

class adaptadorListar: RecyclerView.Adapter<adaptadorListar.MyViewHolder>() {

    var listaAtividades = emptyList<atividadeFisica>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.modelolista, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val atividade = this.listaAtividades[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.textView).text = atividade.nome
            findViewById<TextView>(R.id.textView3).text = atividade.caracteristica
        }

        holder.itemView.findViewById<ConstraintLayout>(R.id.modelolista).setOnClickListener{
            val action = ListarDirections.actionListarToDetalhes(atividade)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return this.listaAtividades.size
    }

    fun setData(atividades: List<atividadeFisica>){
        this.listaAtividades = atividades
        notifyDataSetChanged()
    }
}