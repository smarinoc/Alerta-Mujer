package com.udea.alerta.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udea.alerta.data.entities.AyudaEntity

@Dao
interface AyudaDao {

    @Query("SELECT * FROM ayuda_table")
    fun getAllAyudas(): LiveData<List<AyudaEntity>>

    @Query("SELECT * FROM ayuda_table WHERE id = :id")
    fun getById(id: Int): AyudaEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ayuda: AyudaEntity)

    @Update
    fun update(ayuda: AyudaEntity)

    @Delete
    fun delete(ayuda: AyudaEntity)

}