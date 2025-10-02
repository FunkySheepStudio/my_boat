package com.example.my_boat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.my_boat.databinding.FragmentBoatsBinding
import androidx.navigation.findNavController
import com.example.my_boat.*

class BoatsFragment : Fragment() {
    private var _binding: FragmentBoatsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddBoat.setOnClickListener {
            view.findNavController().navigate(R.id.addBoatFragment)
        }
    }
}