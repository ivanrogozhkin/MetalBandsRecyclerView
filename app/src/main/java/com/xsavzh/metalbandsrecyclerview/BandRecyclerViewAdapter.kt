package com.xsavzh.metalbandsrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xsavzh.metalbandsrecyclerview.databinding.BandItemBinding

class BandRecyclerViewAdapter: RecyclerView.Adapter<BandRecyclerViewAdapter.BandHolder>() {

    private val bandList = ArrayList<Band>()

    class BandHolder(item: View): ViewHolder(item) {
        private val binding = BandItemBinding.bind(item)

        fun bind(band: Band) = with(binding) {
            bandImageView.setImageResource(band.imageId)
            bandTextView.text = band.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.band_item, parent, false)
        return BandHolder(view)
    }

    override fun onBindViewHolder(holder: BandHolder, position: Int) {
        holder.bind(bandList[position])
    }

    override fun getItemCount(): Int {
        return bandList.size
    }

    fun addBand(band: Band) {
        bandList.add(band)
        notifyDataSetChanged()
    }

}