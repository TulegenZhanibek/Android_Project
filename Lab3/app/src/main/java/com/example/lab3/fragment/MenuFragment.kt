package com.example.lab3.fragment

import MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.R
import com.example.lab3.entity.Menu

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        // Get reference to RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // Set up LinearLayoutManager
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        // Set up your adapter
        val menuItems = listOf(
            Menu("Item 1"),
            Menu("Item 2"),
            Menu("Item 3"),
            Menu("Item 4"),
            Menu("Item 5")
        )
        val adapter = MenuAdapter()
        recyclerView.adapter = adapter

        // Submit list to adapter
        adapter.submitList(menuItems)

        return view
    }
}