package com.udea.alerta.repository

import androidx.lifecycle.LiveData
import com.udea.alerta.data.dao.AyudaDao
import com.udea.alerta.data.entities.AyudaEntity
import javax.inject.Inject

interface AyudaRepositorio {
    fun getAllAyudas(): LiveData<List<AyudaEntity>>
    suspend fun getById(id: Int) : AyudaEntity
    suspend fun insert(ayuda: AyudaEntity)
    suspend fun update(ayuda: AyudaEntity)
    suspend fun delete(ayuda: AyudaEntity)
}


class AyudaRepositorioRoom @Inject constructor(
    private val ayudaDao: AyudaDao
): AyudaRepositorio {
    override fun getAllAyudas(): LiveData<List<AyudaEntity>> {
        return ayudaDao.getAllAyudas()
    }

    override suspend fun getById(id: Int): AyudaEntity {
        return ayudaDao.getById(id)
    }

    override suspend fun insert(ayuda: AyudaEntity) {
        return ayudaDao.insert(ayuda)
    }

    override suspend fun update(ayuda: AyudaEntity) {
        return ayudaDao.update(ayuda)
    }

    override suspend fun delete(ayuda: AyudaEntity) {
        return ayudaDao.delete(ayuda)
    }
}