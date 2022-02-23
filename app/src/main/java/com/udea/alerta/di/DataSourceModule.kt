package com.udea.alerta.di

import android.content.Context
import androidx.room.Room
import com.udea.alerta.data.DataBase
import com.udea.alerta.data.dao.AyudaDao
import com.udea.alerta.data.dao.GuardianDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "alerta_database")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun guardianDao(db: DataBase): GuardianDao = db.getGuardianDao()

    @Singleton
    @Provides
    fun ayudaDao(db: DataBase): AyudaDao = db.getAyudaDao()

}