package com.udea.alerta.data.dao

import androidx.room.*
import com.udea.alerta.data.entities.GuardianEntity

@Dao
interface GuardianDao {

    @Query("SELECT * FROM guardian_table")
    suspend fun getAllGuardianes():List<GuardianEntity>

    @Query("SELECT * FROM guardian_table WHERE id = :id")
    suspend fun getById(id: Int): GuardianEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(guardianes:List<GuardianEntity>)

    @Update
    suspend fun update(guardian: GuardianEntity)

    @Delete
    suspend fun delete(guardian: GuardianEntity)
}