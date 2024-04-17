package com.limheejin.camp_carrotmarket.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limheejin.camp_carrotmarket.data.Item
import com.limheejin.camp_carrotmarket.databinding.ItemItemsBinding

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = items.size

    inner class MyViewHolder(val binding: ItemItemsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Item){
            with(binding){
                ivItemImage.setImageResource(data.itemImage)
                tvItemName.text = data.name
                tvItemAddress.text = data.address
//                tvItemPrice.text = data.price Decimal로
                tvChatCount.text = data.chatCount.toString()
                tvHeartCount.text = data.likeCount.toString()
            }
        }
    }

}