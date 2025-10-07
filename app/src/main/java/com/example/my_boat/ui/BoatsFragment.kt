package com.example.my_boat.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import com.example.my_boat.databinding.FragmentBoatsBinding
import androidx.navigation.findNavController
import com.couchbase.lite.DataSource
import com.couchbase.lite.QueryBuilder
import com.couchbase.lite.SelectResult
import com.example.my_boat.*
import com.example.my_boat.data.MyBoatDatabase

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

        val boats = MyBoatDatabase.INSTANCE?.boatDao()?.getAll()

        Log.w("com.example.my_boat","    Collection :: $boats")
        binding.listBoats.setContent {
            LazyColumn {
                boats?.forEach {
                    item {
                        Text(text = it.name)
                    }
                }
            }
        }
        /*val database = Database.getInstance()
        val boats = database.db.getCollection("boats")
            ?: throw IllegalStateException("collection not found")

        val query = QueryBuilder
            .select(SelectResult.all())
            .from(DataSource.collection(boats))

        val token = query.addChangeListener { change ->
            change.results?.let { rs ->
                binding.listBoats.setContent {
                    LazyColumn {
                        rs.forEach {
                            val thisDocsProps = it.getDictionary(0)
                            item {
                                Text(text = thisDocsProps!!.getString("name")?:"")
                            }
                        }
                    }
                }
            }
        }*/

        binding.fabAddBoat.setOnClickListener {
            view.findNavController().navigate(R.id.addBoatFragment)
        }
    }
}