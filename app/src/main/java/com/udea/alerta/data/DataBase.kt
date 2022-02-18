package com.udea.alerta.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udea.alerta.data.dao.GuardianDao
import com.udea.alerta.data.entities.GuardianEntity

@Database(entities = [GuardianEntity::class], version = 1)
abstract class DataBase() :RoomDatabase() {
    abstract fun getGuardianDao():GuardianDao
}