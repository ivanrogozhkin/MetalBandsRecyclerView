package com.xsavzh.metalbandsrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.xsavzh.metalbandsrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = BandRecyclerViewAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter
        init()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            adapter.addBand(it.data?.getSerializableExtra("band") as Band)
        }
    }

    fun init() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
        addBandButton.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}