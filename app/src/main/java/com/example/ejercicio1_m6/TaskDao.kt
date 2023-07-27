package com.example.ejercicio1_m6

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDao {
    @Insert
    suspend fun insertarTarea(task:Task)



}
