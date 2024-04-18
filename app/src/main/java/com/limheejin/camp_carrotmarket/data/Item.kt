package com.limheejin.camp_carrotmarket.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.text.DecimalFormat

@Parcelize
data class Item(
    val id : Int,
    val name : String,
    val content : String,
    val seller : String,
    val price : Int,
    val address : String,
    val likeCount : Int,
    val chatCount : Int,
    @DrawableRes val itemImage : Int
): Parcelable

fun priceDecimal(price: Int): String = DecimalFormat("###,###,###.##").format(price)

