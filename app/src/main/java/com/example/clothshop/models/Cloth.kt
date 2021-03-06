package com.example.clothshop.models

import androidx.databinding.Bindable
import com.example.clothshop.utilities.ClothType

class Cloth(id : Int?, cloth: String?, type: ClothType?, cost: Int?, timesOfBought : Int?, isInInventory: Boolean?, stock : Int?, orderCount : Int?)
{
    private var id : Int? = null
    private var cloth : String? = null
    private var type : ClothType? = null
    private var cost : Int? = null
    private var timesOfBought : Int? = null
    private var isInInventory : Boolean? = null
    private var imageID : Int? = null
    private var stock : Int? = null
    private var orderCount : Int? = null

    init
    {
        this.id = id
        this.cloth = cloth
        this.type = type
        this.cost = cost
        this.timesOfBought = timesOfBought
        this.isInInventory = isInInventory
        this.stock = stock
        this.orderCount = orderCount
    }

    fun setOrderCount(orderCount : Int?){this.orderCount = orderCount;}
    fun setStock(stock : Int?){this.stock = stock;}
    fun setId(id : Int?){this.id = id;}
    fun setCloth(cloth : String?){this.cloth = cloth;}
    fun setType(type : ClothType?){this.type = type;}
    fun setCost(cost : Int?) {this.cost = cost;}
    fun setTimesOfBought(timesOfBought : Int?) {this.timesOfBought = timesOfBought;}
    fun setIsInInventory(isInInventory : Boolean?) {this.isInInventory = isInInventory;}

    fun getOrderCount(): Int? {return this.orderCount}
    fun getStock(): Int? {return this.stock}
    fun getId(): Int? {return this.id}
    fun getCloth(): String? {return this.cloth}
    fun getType(): ClothType? {return this.type}
    fun getCost(): Int? {return this.cost}
    fun getTimesOfBought(): Int? {return this.timesOfBought}
    fun getIsInInventory(): String? { return if (this.isInInventory!!) {"Raktáron"} else {"Nincs raktáron"}}
    fun getImageID() : Int? {return this.imageID}


}