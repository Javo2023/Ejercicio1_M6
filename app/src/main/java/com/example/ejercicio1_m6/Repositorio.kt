package com.example.ejercicio1_m6

import androidx.lifecycle.LiveData

class Repositorio (private val taskDao: TaskDao){
    suspend fun insertTask(task : Task){
        taskDao.insertarTarea(task)  // insertar tarea

    }
    fun getTareas(): LiveData<List<Task>>{
        return taskDao.getTasks() //obtener tarea

    }
}