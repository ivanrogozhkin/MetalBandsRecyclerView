package com.xsavzh.metalbandsrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xsavzh.metalbandsrecyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    
    private var imageIndex = 0
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

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()
    }

    private fun initButtons() = with(binding) {

        nextPicButton.setOnClickListener {
            imageIndex++
            if (imageIndex > imageList.size - 1) imageIndex = 0
            imageId = imageList[imageIndex]
            bandImageView.setImageResource(imageId)
        }

        prevPicButton.setOnClickListener {
            imageIndex--
            if (imageIndex < 0) imageIndex = imageList.size - 1
            imageId = imageList[imageIndex]
            bandImageView.setImageResource(imageId)
        }

        doneButton.setOnClickListener {
            val band = Band(imageId, titleEditText.text.toString())
            val editIntent = Intent().apply {
                putExtra("band", band)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}