package com.example.clothshop.models.builders

import com.example.clothshop.models.Cloth
import com.example.clothshop.Utilities.ClothType

class ClothBuilder
{
    private var cloth : String? = null;
    private var type : ClothType? = null;
    private var cost : Int? = null;
    private var isBought : Boolean? = null;
    private var isInInventory : Boolean? = null;
    private var isOrdered : Boolean? = null;
    private var isDeleted : Boolean? = null;

    fun setCloth(cloth : String?) : ClothBuilder?
    {
        this.cloth = cloth;
        return this;
    }
    fun setType(type : ClothType?) : ClothBuilder?
    {
        this.type = type;
        return this;
    }
    fun setCost(cost : Int?) : ClothBuilder?
    {
        this.cost = cost;
        return this;
    }
    fun setIsBought(isBought : Boolean?) : ClothBuilder?
    {
        this.isBought = isBought;
        return this;
    }
    fun setIsInInventory(isInInventory : Boolean?) : ClothBuilder?
    {
        this.isInInventory = isInInventory;
        return this;
    }
    fun setIsOrdered(isOrdered : Boolean?) : ClothBuilder?
    {
        this.isOrdered = isOrdered;
        return this;
    }
    fun setDeleted(isDeleted : Boolean?) : ClothBuilder?
    {
        this.isDeleted = isDeleted;
        return this;
    }

    fun getClothBuilder() : Cloth {return Cloth(); }
}