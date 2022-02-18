package com.udea.alerta.repository

import androidx.lifecycle.LiveData
import com.udea.alerta.data.dao.GuardianDao
import com.udea.alerta.data.entities.GuardianEntity
import javax.inject.Inject

interface GuardianRepositorio {
     fun getAllGuardianes(): LiveData<List<GuardianEntity>>
     suspend fun getById(id: Int) : GuardianEntity
     suspend fun insert(guardian: GuardianEntity)
     suspend fun update(guardian: GuardianEntity)
     suspend fun delete(guardian: GuardianEntity)
}


class GuardianRepositorioRoom @Inject constructor(
    private val guardianDao: GuardianDao
): GuardianRepositorio {
    override fun getAllGuardianes(): LiveData<List<GuardianEntity>> {
        return guardianDao.getAllGuardianes()
    }

    override suspend fun getById(id: Int): GuardianEntity {
        return guardianDao.getById(id)
    }

    override suspend fun insert(guardian: GuardianEntity) {
        return guardianDao.insert(guardian)
    }

    override suspend fun update(guardian: GuardianEntity) {
        return guardianDao.update(guardian)
    }

    override suspend fun delete(guardian: GuardianEntity) {
        return guardianDao.delete(guardian)
    }
}