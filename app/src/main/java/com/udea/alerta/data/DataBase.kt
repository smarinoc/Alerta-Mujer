package com.udea.alerta.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udea.alerta.data.dao.AyudaDao
import com.udea.alerta.data.dao.GuardianDao
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.data.entities.GuardianEntity

@Database(entities = [GuardianEntity::class, AyudaEntity::class], version = 2)
abstract class DataBase() :RoomDatabase() {
    abstract fun getGuardianDao():GuardianDao
    abstract fun getAyudaDao():AyudaDao
}