package com.example.ejercicio1_m6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio1_m6.databinding.ActivityMainBinding

/*
[x] Navigation
[x] Crear Fragmentos Agregar
[x] Crear Interfaz para agregar nueva tarea
[x]Room
    [x]Entity
    [x]Dao
    [x]BAse_datos

[x] Crear Fragmentos Listado

[]RecyclerView
*/

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}