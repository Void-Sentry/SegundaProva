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

class editar : Fragment() {

    private lateinit var ViewModel: viewModel
    private val args by navArgs<editarArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.ViewModel = ViewModelProvider(this).get(viewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_editar, container, false)

        view.findViewById<EditText>(R.id.nome)?.setText(args.editar.nome)
        view.findViewById<EditText>(R.id.duracao)?.setText(args.editar.duracao.toString())
        view.findViewById<EditText>(R.id.calorias)?.setText(args.editar.calorias.toString())
        view.findViewById<EditText>(R.id.tipo)?.setText(args.editar.tipo)
        view.findViewById<EditText>(R.id.carateristica)?.setText(args.editar.caracteristica)

        view.findViewById<Button>(R.id.atalizar).setOnClickListener {
            ViewModel.atualizar(
                atividadeFisica(
                    args.editar.id,
                    view.findViewById<EditText>(R.id.nome).text.toString(),
                    view.findViewById<EditText>(R.id.duracao).text.toString().toFloat(),
                    view.findViewById<EditText>(R.id.calorias).text.toString().toFloat(),
                    view.findViewById<EditText>(R.id.tipo)?.text.toString(),
                    view.findViewById<EditText>(R.id.carateristica).text.toString()
                )
            )
            findNavController().navigate(R.id.action_editar_to_listar)
            Toast.makeText(context, "atividade atualizada", Toast.LENGTH_LONG).show()
        }

        return view
    }

}