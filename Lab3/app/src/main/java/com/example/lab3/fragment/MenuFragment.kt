package com.example.lab3.fragment

import MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.R
import com.example.lab3.databinding.FragmentMenuBinding
import com.example.lab3.entity.Menu
import com.example.lab3.model.BannerViewModel

class MenuFragment : Fragment() {
    private lateinit var bannerViewModel: BannerViewModel
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bannerViewModel = ViewModelProvider(this).get(BannerViewModel::class.java)

//        initBanner()

        // Navigation of card
        binding.nextCart.setOnClickListener {
            val fragment = CartFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }

        // Navigation of wishlist
        binding.nextWishlist.setOnClickListener {
            val fragment = WishlistFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }

        // Navigation of my order
        binding.nextMyOrder.setOnClickListener {
            val fragment = WishlistFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }

        // Navigation of profile
        binding.nextProfile.setOnClickListener {
            val fragment = CartFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_view, fragment)?.commit()
        }

        // Adapter for RecyclerView
        val recyclerView: RecyclerView = binding.recyclerView
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
    }

//    private fun initBanner() {
//        binding.progressbarBanner.visibility = View.VISIBLE
//        bannerViewModel.banners.observe(viewLifecycleOwner, Observer { items ->
//            binding.progressbarBanner.visibility = View.GONE
//            setupBanner(items)
//        })
//        bannerViewModel.loadBanners()
//    }
//
//    private fun setupBanner(images: List<SliderModel>) {
//        binding.viewPagerSlider.adapter = SliderAdapter(images)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}
