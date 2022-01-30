package com.example.segundaprova.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "atividade_fisica")
data class atividadeFisica(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var nome: String,
    var duracao: Float,
    var calorias: Float,
    var tipo: String,
    var caracteristica: String
):Parcelable