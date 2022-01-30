package com.example.segundaprova

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.adaptadores.adaptadorListar
import com.example.segundaprova.data.viewModel.viewModel

class Listar : Fragment() {
    private lateinit var ViewModel: viewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listar, container, false)
        this.ViewModel = ViewModelProvider(this).get(viewModel::class.java)

        var adapter = adaptadorListar()

        view.findViewById<RecyclerView>(R.id.listaDeAtividades).adapter = adapter
        view.findViewById<RecyclerView>(R.id.listaDeAtividades).layoutManager =
            LinearLayoutManager(requireContext())

        this.ViewModel.listaDeAtividadesExistentes.observe(viewLifecycleOwner, { adapter.setData(it) })
        view.findViewById<Button>(R.id.button2).setBackgroundColor(Color.parseColor("#000000"))
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            findNavController().navigate(R.id.action_listar_to_criar)
        }

        return view
    }
}