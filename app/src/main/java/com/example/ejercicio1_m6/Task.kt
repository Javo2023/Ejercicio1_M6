package com.example.ejercicio1_m6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_tarea")
data class Task(val nombre: String, val fecha: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
