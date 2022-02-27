package com.udea.alerta.repository

import androidx.lifecycle.LiveData
import com.udea.alerta.data.dao.PreguntaDao
import com.udea.alerta.data.entities.PreguntaEntity
import javax.inject.Inject

interface PreguntaRepositorio {
    fun getAllPreguntas(): LiveData<List<PreguntaEntity>>
    suspend fun getById(id: Int) : PreguntaEntity
    suspend fun insert(pregunta: PreguntaEntity)
    suspend fun update(pregunta: PreguntaEntity)
    suspend fun delete(pregunta: PreguntaEntity)
}


class PreguntaRepositorioRoom @Inject constructor(
    private val preguntaDao: PreguntaDao
): PreguntaRepositorio {
    override fun getAllPreguntas(): LiveData<List<PreguntaEntity>> {
        return preguntaDao.getAllPreguntas()
    }

    override suspend fun getById(id: Int): PreguntaEntity {
        return preguntaDao.getById(id)
    }

    override suspend fun insert(pregunta: PreguntaEntity) {
        return preguntaDao.insert(pregunta)
    }

    override suspend fun update(pregunta: PreguntaEntity) {
        return preguntaDao.update(pregunta)
    }

    override suspend fun delete(pregunta: PreguntaEntity) {
        return preguntaDao.delete(pregunta)
    }
}