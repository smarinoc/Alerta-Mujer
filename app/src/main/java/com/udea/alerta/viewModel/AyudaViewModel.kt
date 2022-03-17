package com.udea.alerta.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.repository.AyudaRepositorioRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AyudaViewModel @Inject constructor(
    private val ayudaRepositorioRoom: AyudaRepositorioRoom
):  ViewModel(){


    val ayudas: LiveData<List<AyudaEntity>> by lazy {
        ayudaRepositorioRoom.getAllAyudas()
    }

    fun addAyuda( ayuda: AyudaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            ayudaRepositorioRoom.insert(ayuda)
        }
    }

    fun deleteGuardian( ayuda: AyudaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            ayudaRepositorioRoom.delete(ayuda)
        }
    }

    fun updateGuardian( ayuda: AyudaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            ayudaRepositorioRoom.update(ayuda)
        }
    }

}