package com.udea.alerta.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udea.alerta.data.entities.GuardianEntity

@Dao
interface GuardianDao {

    @Query("SELECT * FROM guardian_table")
    fun getAllGuardianes(): LiveData<List<GuardianEntity>>

    @Query("SELECT * FROM guardian_table WHERE id = :id")
    fun getById(id: Int): GuardianEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(guardian: GuardianEntity)

    @Update
    fun update(guardian: GuardianEntity)

    @Delete
    fun delete(guardian: GuardianEntity)
}