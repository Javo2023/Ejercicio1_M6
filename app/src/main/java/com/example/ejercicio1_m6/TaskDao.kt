package com.example.ejercicio1_m6

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insertarTarea(task:Task)

@Query("Select * From tabla_tarea order by id asc")

fun getTasks(): LiveData<List<Task>>

}
