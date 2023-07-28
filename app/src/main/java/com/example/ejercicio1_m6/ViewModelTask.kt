package com.example.ejercicio1_m6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelTask (aplication: Application) : AndroidViewModel(aplication) {
    private var repositorio : Repositorio

    init{
        repositorio = Repositorio(TaskData.getDatabase(aplication).getTaskDao())

    }
    //Usa el repositorio para obtener tareas
    fun obtenerTareas(): LiveData<List<Task>> {
        return repositorio.getTareas()

    }
    fun insertarTarea(task: Task)= viewModelScope.launch{
        repositorio.insertTask(task)

    }

}
