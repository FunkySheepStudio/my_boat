package com.example.my_boat.ui.manoeuvres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.my_boat.databinding.FragmentManoeuvresBinding

class ManoeuvresFragment : Fragment() {

    private var _binding: FragmentManoeuvresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val manoeuvresViewModel =
            ViewModelProvider(this).get(ManoeuvresViewModel::class.java)

        _binding = FragmentManoeuvresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textManoeuvres
        manoeuvresViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}