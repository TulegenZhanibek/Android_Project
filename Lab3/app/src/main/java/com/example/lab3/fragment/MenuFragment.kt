package com.example.lab3.fragment

import MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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

        // navigation of card
        val nextCartLinearLayout: LinearLayout = view.findViewById(R.id.next_cart)
        nextCartLinearLayout.setOnClickListener {
            val fragment = CartFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }

        // navigation of wishlist
        val nextWishlistLinearLayout: LinearLayout = view.findViewById(R.id.next_wishlist)
        nextWishlistLinearLayout.setOnClickListener {
            val fragment = WishlistFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }
        // navigation of my order
        val nextMyOrderLinearLayout: LinearLayout = view.findViewById(R.id.next_my_order)
        nextMyOrderLinearLayout.setOnClickListener {
            val fragment = WishlistFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }
        // navigation of profile
        val nextProfileLinearLayout: LinearLayout = view.findViewById(R.id.next_profile)
        nextProfileLinearLayout.setOnClickListener {
            val fragment = CartFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }


        //Adapter
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
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