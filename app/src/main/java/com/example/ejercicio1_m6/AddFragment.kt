package com.example.ejercicio1_m6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

  lateinit var binding : FragmentAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater,container,false)
      initListener()
        return binding.root
    }

    private fun initListener() {
        binding.buttonAddTask.setOnClickListener(){
            val texto = binding.etAddTask.text.toString()
            saveTask(texto)
        }
    }

    private fun saveTask(texto:String) {
        val dao =TaskData.getDatabase(requireContext()).getTaskDao()
        val task = Task(texto,"fecha")
        GlobalScope.launch { dao.insertarTarea(task) }

    }


}