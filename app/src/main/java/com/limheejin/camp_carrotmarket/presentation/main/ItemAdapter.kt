package com.limheejin.camp_carrotmarket.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limheejin.camp_carrotmarket.model.Item
import com.limheejin.camp_carrotmarket.model.priceDecimal
import com.limheejin.camp_carrotmarket.databinding.ItemItemsBinding

class ItemAdapter(
    private val onClick: (Int) -> Unit,
    private val onLongClick: (Int) -> Boolean
) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){

    var items: List<Item> = listOf()

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
        init {
            with(itemView){
                setOnClickListener { onClick(adapterPosition) }
                setOnLongClickListener { onLongClick(adapterPosition) }
            }
        }
        fun bind(data: Item){
            with(binding){
                ivItemImage.setImageResource(data.itemImage)
                tvItemName.text = data.name
                tvItemAddress.text = data.address
                tvItemPrice.text = priceDecimal(data.price) + "원"
                tvChatCount.text = data.chatCount.toString()
                tvHeartCount.text = data.likeCount.toString()
            }
        }

    }

}