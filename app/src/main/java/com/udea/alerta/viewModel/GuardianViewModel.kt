package com.udea.alerta.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.repository.GuardianRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuardianViewModel @Inject constructor(
    private val guardianRepositorioRoom: GuardianRepositorio
):  ViewModel(){


    val guardianes: LiveData<List<GuardianEntity>> by lazy {
        guardianRepositorioRoom.getAllGuardianes()
    }

    fun addGuardian( guardian: GuardianEntity) {
            viewModelScope.launch(Dispatchers.IO) {
                guardianRepositorioRoom.insert(guardian)
            }
    }

    fun deleteGuardian( guardian: GuardianEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            guardianRepositorioRoom.delete(guardian)
        }
    }

    fun updateGuardian( guardian: GuardianEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            guardianRepositorioRoom.update(guardian)
        }
    }

}