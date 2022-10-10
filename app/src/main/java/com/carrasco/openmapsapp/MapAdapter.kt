package com.carrasco.openmapsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carrasco.openmapsapp.databinding.MapViewItemBinding

class MapAdapter(private val locations: List<Place>, val listener: (Place) -> Unit)
    : RecyclerView.Adapter<MapAdapter.ViewHolder>(){

    class ViewHolder(private val binding: MapViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(place: Place){
            binding.placeName.text = place.name
            Glide.with(binding.root.context).load(place.image).into(binding.imagePlace)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = MapViewItemBinding.inflate(
            LayoutInflater.from(p0.context), p0, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val place = locations[p1]
        p0.bind(place)
        p0.itemView.setOnClickListener{
            listener(place)
        }
    }

    override fun getItemCount() = locations.size
}