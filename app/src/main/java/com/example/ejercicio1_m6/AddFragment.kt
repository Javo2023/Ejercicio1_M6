package com.example.ejercicio1_m6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.example.ejercicio1_m6.databinding.FragmentAddBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

  lateinit var binding : FragmentAddBinding   // enlaza binding
  lateinit var repositorio : Repositorio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater,container,false) // inicializa binding
        initRepositorio()
      initListener()
        loadTask()
        return binding.root
    }

    private fun initRepositorio() {
        repositorio = Repositorio(TaskData.getDatabase(requireContext()).getTaskDao())
    }

    private fun initListener() {
        binding.buttonAddTask.setOnClickListener(){
            val texto = binding.etAddTask.text.toString()
            saveTask(texto)
            Toast.makeText(requireContext(), " Texto agregado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveTask(texto:String) {

        val task = Task(texto," ")
        GlobalScope.launch { repositorio.insertTask(task) }


    }
    private fun loadTask(){


            repositorio.getTareas().observe(requireActivity()){
                val tasksAsText = it.joinToString("\n") { it.nombre }
                binding.tvShow.text = tasksAsText
            }


    }


}