package com.example.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.data.model.atividadeFisica
import com.example.segundaprova.data.viewModel.viewModel

class Criar : Fragment() {

    private lateinit var ViewModel: viewModel
    private val args by navArgs<CriarArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.ViewModel = ViewModelProvider(this).get(viewModel::class.java)
        val view = inflater.inflate(R.layout.modelocriar, container, false)


        view.findViewById<Button>(R.id.button).setOnClickListener {
            ViewModel.inserir(
                atividadeFisica(
                    0,
                    view.findViewById<EditText>(R.id.nome).text.toString(),
                    view.findViewById<EditText>(R.id.duracao).text.toString().toFloat(),
                    view.findViewById<EditText>(R.id.calorias).text.toString().toFloat(),
                    view.findViewById<EditText>(R.id.tipo).text.toString(),
                    view.findViewById<EditText>(R.id.carateristica).text.toString()
                )
            )
            findNavController().navigate(R.id.action_criar_to_listar)
            Toast.makeText(context, "atividade cadastrada", Toast.LENGTH_LONG).show()
        }

        return view
    }
}