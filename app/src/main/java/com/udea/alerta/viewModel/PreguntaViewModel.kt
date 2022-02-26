package com.udea.alerta.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.alerta.data.entities.PreguntaEntity
import com.udea.alerta.repository.PreguntaRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreguntaViewModel @Inject constructor(
    private val preguntaRepositorioRoom: PreguntaRepositorio
):  ViewModel(){


    val preguntas: LiveData<List<PreguntaEntity>> by lazy {
        preguntaRepositorioRoom.getAllPreguntas()
    }

    fun addPregunta( pregunta: PreguntaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            preguntaRepositorioRoom.insert(pregunta)
        }
    }

    fun deletePregunta( pregunta: PreguntaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            preguntaRepositorioRoom.delete(pregunta)
        }
    }

    fun updatePregunta(pregunta: PreguntaEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            preguntaRepositorioRoom.update(pregunta)
        }
    }

}