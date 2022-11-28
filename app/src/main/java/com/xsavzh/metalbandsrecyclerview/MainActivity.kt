package com.xsavzh.metalbandsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xsavzh.metalbandsrecyclerview.databinding.ActivityMainBinding
import com.xsavzh.metalbandsrecyclerview.databinding.BandItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemBinding: BandItemBinding
    private val adapter = BandRecyclerViewAdapter()

    private var imageId = R.drawable.darkthrone
    private var imageList = listOf(
        R.drawable.darkthrone,
        R.drawable.emperor,
        R.drawable.filosofem,
        R.drawable.mayhem,
        R.drawable.sepultura
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        itemBinding = BandItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter
        init()
    }

    fun init() = with(binding) {
        var bandTitle: String
        var imageIndex: Int = 0

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
        addBandButton.setOnClickListener {
            bandTitle = when (imageId) {
                R.drawable.darkthrone -> "Darkthrone"
                R.drawable.emperor -> "Emperor"
                R.drawable.filosofem -> "Filosofem"
                R.drawable.mayhem -> "Mayhem"
                R.drawable.sepultura -> "Sepultura"
                else -> ({}).toString()
            }

            imageIndex++
            if (imageIndex > imageList.size - 1) imageIndex = 0
            imageId = imageList[imageIndex]
            itemBinding.bandImageView.setImageResource(imageId)

            val band = Band(imageId, bandTitle)
            adapter.addBand(band)
        }
    }
}