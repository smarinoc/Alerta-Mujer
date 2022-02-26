package com.udea.alerta.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pregunta_table")
data class PreguntaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "pregunta") val pregunta: String,
    @ColumnInfo(name = "puntaje") val puntaje: Int,
    @ColumnInfo(name = "depende") val depende: Int
)