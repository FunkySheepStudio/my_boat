package com.example.my_boat.ui.maintenance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.my_boat.databinding.FragmentMaintenanceBinding

class MaintenanceFragment : Fragment() {

    private var _binding: FragmentMaintenanceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val maintenanceViewModel =
            ViewModelProvider(this).get(MaintenanceViewModel::class.java)

        _binding = FragmentMaintenanceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMaintenance
        maintenanceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}