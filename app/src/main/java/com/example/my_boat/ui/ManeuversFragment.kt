package com.example.my_boat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.my_boat.databinding.FragmentManeuversBinding

class ManeuversFragment : Fragment() {
    private var _binding: FragmentManeuversBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManeuversBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}