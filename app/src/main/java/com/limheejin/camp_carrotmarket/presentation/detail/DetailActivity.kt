package com.limheejin.camp_carrotmarket.presentation.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.limheejin.camp_carrotmarket.R
import com.limheejin.camp_carrotmarket.data.ItemList
import com.limheejin.camp_carrotmarket.databinding.ActivityDetailBinding
import com.limheejin.camp_carrotmarket.model.Item
import com.limheejin.camp_carrotmarket.model.priceDecimal

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val selectedItem by lazy {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra("itemFromMainActivity", Item::class.java)
        } else {
            intent.getParcelableExtra("itemFromMainActivity")
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
        binding.btnStartChat.setOnClickListener { createNewChat() }
    }

    private fun setItem() {
        selectedItem?.let {
            binding.ivDetailItemImage.setImageResource(it.itemImage)
            binding.tvSeller.text = it.seller
            binding.tvDetailAddress.text = it.address
            binding.tvDetailItemName.text = it.name
            binding.tvDetailItemContent.text = it.content
            binding.tvDetailItemPrice.text = priceDecimal(it.price) + "원"
        }
    }

    private fun createNewChat() {
        (Toast.makeText(this, "아직 채팅 기능은 구현 중이에요.", Toast.LENGTH_SHORT)).show()
    }

}