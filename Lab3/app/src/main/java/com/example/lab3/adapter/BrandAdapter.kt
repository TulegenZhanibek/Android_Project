package com.example.lab3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.lab3.databinding.ViewholderBrandBinding
import com.example.lab3.entity.ItemModel


class BrandAdapter(val items: MutableList<ItemModel>) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>() {
    private var context:Context?=null
    class ViewHolder(val binding: ViewholderBrandBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandAdapter.ViewHolder {
        context=parent.context
        val binding=
            ViewholderBrandBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandAdapter.ViewHolder, position: Int) {
        holder.binding.nameTxt.text = items[position].name
        holder.binding.priceTxt.text = "T" + items[position].price.toString()
        holder.binding.ratingTxt.text = items[position].rating.toString()

        val requestOptions=RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .apply(requestOptions)
            .into(holder.binding.pic)

//        holder.itemView.setOnClickListener{
//            val intent= Intent(holder.itemView.context)
//        }
    }

    override fun getItemCount(): Int = items.size
}