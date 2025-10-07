package com.example.my_boat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.my_boat.databinding.FragmentAddBoatBinding
import com.example.my_boat.data.Boat
import com.example.my_boat.data.MyBoatDatabase

class AddBoatFragment : Fragment() {
    private var _binding: FragmentAddBoatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBoatBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabSaveBoat.setOnClickListener {
            val boat = Boat(name = binding.txtName.text.toString())
            MyBoatDatabase.INSTANCE?.boatDao()?.insert(boat)
        }
    }
}