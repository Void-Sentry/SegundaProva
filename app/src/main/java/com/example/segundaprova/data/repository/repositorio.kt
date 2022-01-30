package com.example.segundaprova.data.repository

import androidx.lifecycle.LiveData
import com.example.segundaprova.data.DAO.DAO
import com.example.segundaprova.data.model.atividadeFisica

class repositorio(var atividadeFisicaDAO: DAO) {

    val listaAtividades: LiveData<List<atividadeFisica>> = atividadeFisicaDAO.listarTudoAtividadeFisica()

    fun inserirAtividadeFisica(atividadeFisica: atividadeFisica){
        atividadeFisicaDAO.inserirAtividadeFisica(atividadeFisica)
    }

    fun deletarAtividadeFisica(atividadeFisica: atividadeFisica){
        atividadeFisicaDAO.deletarAtividadeFisica(atividadeFisica)
    }

    fun atualizarAtividadeFisica(atividadeFisica: atividadeFisica){
        atividadeFisicaDAO.atualizarAtividadeFisica(atividadeFisica)
    }

    fun ListarAtividadeFisica(){
        atividadeFisicaDAO.listarTudoAtividadeFisica()
    }

    fun ListarPorIdAtividadeFisica(atividadeFisicaId: Long): LiveData<atividadeFisica>{
        return atividadeFisicaDAO.filtrarPorId(atividadeFisicaId)
    }

    fun deletarTudoAtividadeFisica(){
        atividadeFisicaDAO.deletarTudo()
    }
}