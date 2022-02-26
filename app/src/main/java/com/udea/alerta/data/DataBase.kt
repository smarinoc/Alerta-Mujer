package com.udea.alerta.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udea.alerta.data.dao.AyudaDao
import com.udea.alerta.data.dao.GuardianDao
import com.udea.alerta.data.dao.PreguntaDao
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.data.entities.PreguntaEntity

@Database(
    entities = [GuardianEntity::class, AyudaEntity::class, PreguntaEntity::class],
    version = 3
)
abstract class DataBase() : RoomDatabase() {
    abstract fun getGuardianDao(): GuardianDao
    abstract fun getAyudaDao(): AyudaDao
    abstract fun getPreguntaDao(): PreguntaDao
}