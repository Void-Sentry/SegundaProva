package com.example.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.data.model.atividadeFisica
import com.example.segundaprova.data.viewModel.viewModel

class detalhes : Fragment() {

    private lateinit var ViewModel: viewModel
    private val args by navArgs<detalhesArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalhes, container, false)
        this.ViewModel = ViewModelProvider(this).get(viewModel::class.java)
        var filtro = args.telaDescricao.id

        ViewModel.atividadeFisicaPorId(filtro).observe(viewLifecycleOwner, { atividadeFisica ->
            view.findViewById<TextView>(R.id.textView6).text = atividadeFisica.nome
            view.findViewById<TextView>(R.id.textView5).text = atividadeFisica.duracao.toString()
            view.findViewById<TextView>(R.id.textView4).text = atividadeFisica.calorias.toString()
            view.findViewById<TextView>(R.id.textView2).text = atividadeFisica.tipo
            view.findViewById<TextView>(R.id.textView7).text = atividadeFisica.caracteristica
        })

        view.findViewById<Button>(R.id.atualizarDetalhes).setOnClickListener{
            val action = detalhesDirections.actionDetalhesToEditar(args.telaDescricao)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.deletarDetalhes).setOnClickListener{
            ViewModel.deletar(args.telaDescricao)
            Toast.makeText(context, "Excluido", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_detalhes_to_listar)
        }

        return view
    }

}