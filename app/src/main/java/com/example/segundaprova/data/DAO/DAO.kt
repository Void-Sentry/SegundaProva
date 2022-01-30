package com.example.segundaprova.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.segundaprova.data.model.atividadeFisica

@Dao
interface DAO {

    @Insert
    fun inserirAtividadeFisica(atividadeFisica: atividadeFisica)

    @Delete
    fun deletarAtividadeFisica(atividadeFisica: atividadeFisica)

    @Update
    fun atualizarAtividadeFisica(atividadeFisica: atividadeFisica)

    @Query("SELECT * FROM atividade_fisica")
    fun listarTudoAtividadeFisica(): LiveData<List<atividadeFisica>>

    @Query("SELECT * FROM atividade_fisica WHERE id = :id")
    fun filtrarPorId(id: Long): LiveData<atividadeFisica>

    @Query("DELETE FROM atividade_fisica")
    fun deletarTudo()
}