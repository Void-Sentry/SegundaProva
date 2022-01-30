package com.example.segundaprova.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundaprova.data.DAO.DAO
import com.example.segundaprova.data.model.atividadeFisica

@Database(entities = [atividadeFisica::class], version = 1, exportSchema = false)
abstract class banco: RoomDatabase() {
    abstract fun DAO(): DAO
    companion object {
        @Volatile
        private var INSTANCIA: banco? = null
        fun getDatabase(context: Context): banco {
            val tempInstance = INSTANCIA
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    banco::class.java,
                    "banco"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCIA = instance
                return instance
            }
        }
    }
}