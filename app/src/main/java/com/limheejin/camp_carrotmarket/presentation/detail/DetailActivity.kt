package com.limheejin.camp_carrotmarket.presentation.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.limheejin.camp_carrotmarket.R
import com.limheejin.camp_carrotmarket.data.ItemList
import com.limheejin.camp_carrotmarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val selectedItem by lazy {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra("item", ItemList::class.java)
        } else {
            intent.getParcelableExtra("item")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setItem()
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun setItem() {
        selectedItem?.let {
//            binding.ivDetailItemImage.setImageResource(image)
            binding.tvSeller
            binding.tvDetailAddress
            binding.tvDetailItemName
            binding.tvDetailItemContent
            binding.tvDetailItemPrice
        }
    }


}