package com.udea.alerta.data.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.udea.alerta.data.entities.PreguntaEntity

@Dao
interface PreguntaDao {

    @Query("SELECT * FROM pregunta_table")
    fun getAllPreguntas(): LiveData<List<PreguntaEntity>>

    @Query("SELECT * FROM pregunta_table WHERE id = :id")
    fun getById(id: Int): PreguntaEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pregunta: PreguntaEntity)

    @Update
    fun update(pregunta: PreguntaEntity)

    @Delete
    fun delete(pregunta: PreguntaEntity)
}