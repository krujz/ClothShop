package com.example.clothshop.models.builders

import com.example.clothshop.models.Cloth
import com.example.clothshop.utilities.ClothType

class ClothBuilder
{
    private var id : Int? = null
    private var cloth : String? = null;
    private var type : ClothType? = null;
    private var cost : Int? = null;
    private var timesOfBought : Int? = null
    private var isInInventory : Boolean? = null;
    private var stock : Int? = null
    private var orderCount : Int? = null


    fun setId(id : Int?) : ClothBuilder?
    {
        this.id = id
        return this
    }
    fun setCloth(cloth : String?) : ClothBuilder?
    {
        this.cloth = cloth
        return this
    }
    fun setType(type : ClothType?) : ClothBuilder?
    {
        this.type = type
        return this
    }
    fun setCost(cost : Int?) : ClothBuilder?
    {
        this.cost = cost
        return this
    }
    fun setTimesOfBought(timesOfBought : Int?) : ClothBuilder?
    {
        this.timesOfBought = timesOfBought
        return this

    }
    fun setIsInInventory(isInInventory : Boolean?) : ClothBuilder?
    {
        this.isInInventory = isInInventory
        return this
    }
    fun setStock(stock : Int?) : ClothBuilder?
    {
        this.stock = stock
        return this
    }
    fun setOrderCount(orderCount : Int?) : ClothBuilder?
    {
        this.orderCount = orderCount
        return this
    }

    fun getClothBuilder() : Cloth {return Cloth(id,cloth,type,cost,timesOfBought,isInInventory,stock,orderCount)}
}