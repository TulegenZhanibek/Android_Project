package com.example.lab3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.lab3.R
import com.example.lab3.adapter.BrandAdapter
import com.example.lab3.adapter.SliderAdapter
import com.example.lab3.database.DatabaseHelper
import com.example.lab3.databinding.FragmentMenuBinding
import com.example.lab3.entity.SliderModel
import com.example.lab3.model.MainViewModel

class MenuFragment : Fragment() {
    private lateinit var db: DatabaseHelper
    private var password: String?= null
    private lateinit var viewModel: MainViewModel
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

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initBanner()
        initBrand()

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

        arguments?.let {
            password = it.getString("password")
        }

        // Initialize DatabaseHelper
        db = DatabaseHelper(requireContext())

        // Fetch the username from the database using the password
        val username = password?.let { db.getUsername(it) }

        // Set the username to the TextView
        // Assuming you have a TextView with id tvUsername in your fragment_menu layout
        username?.let {
            view.findViewById<TextView>(R.id.tvUsername).text = it
        }

    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        viewModel.banners.observe(viewLifecycleOwner, Observer { items ->
            banners(items)
            binding.progressBarBanner.visibility = View.GONE
        })
        viewModel.loadBanners()
    }

    private fun banners(images: List<SliderModel>) {
        binding.viewpagerSlider.adapter = SliderAdapter(images, binding.viewpagerSlider)
        binding.viewpagerSlider.clipToPadding = false
        binding.viewpagerSlider.clipChildren = false
        binding.viewpagerSlider.offscreenPageLimit = 3
        binding.viewpagerSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        binding.viewpagerSlider.setPageTransformer(compositePageTransformer)

        if (images.size > 1) {
            binding.dotIndicator.visibility = View.VISIBLE
            binding.dotIndicator.setViewPager2(binding.viewpagerSlider)
        }
    }
    private fun initBrand() {
        binding.progressBarPopular.visibility = View.VISIBLE
        viewModel.popular.observe(viewLifecycleOwner, Observer { items ->
            binding.viewPopular.layoutManager = GridLayoutManager(context, 2)
            binding.viewPopular.adapter = BrandAdapter(items)
            binding.progressBarPopular.visibility = View.GONE
        })
        viewModel.loadBrand()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
