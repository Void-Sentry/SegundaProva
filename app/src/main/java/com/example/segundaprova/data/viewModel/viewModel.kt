package com.example.segundaprova.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.segundaprova.data.database.banco
import com.example.segundaprova.data.model.atividadeFisica
import com.example.segundaprova.data.repository.repositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(application: Application): AndroidViewModel(application) {

    var repo: repositorio
    var listaDeAtividadesExistentes: LiveData<List<atividadeFisica>>

    init {
        val conexao = banco.getDatabase(application).DAO()
        repo = repositorio(conexao)
        listaDeAtividadesExistentes = repo.listaAtividades
    }

    fun inserir(atividadeFisica: atividadeFisica){
        viewModelScope.launch(Dispatchers.IO){
            repo.inserirAtividadeFisica(atividadeFisica)
        }
    }

    fun deletar(atividadeFisica: atividadeFisica){
        viewModelScope.launch(Dispatchers.IO){
            repo.deletarAtividadeFisica(atividadeFisica)
        }
    }

    fun atualizar(atividadeFisica: atividadeFisica){
        viewModelScope.launch(Dispatchers.IO){
            repo.atualizarAtividadeFisica(atividadeFisica)
        }
    }

    fun atividadeFisicaPorId(id: Long): LiveData<atividadeFisica>{
        return repo.ListarPorIdAtividadeFisica(id)
    }
}