package com.example.clothshop.models

import com.example.clothshop.Utilities.ClothType

class Cloth(cloth: String?,type: ClothType?,cost: Int?,isBought: Boolean?,isInInventory: Boolean?,isOrdered: Boolean?,isDeleted: Boolean?)
{
    private var cloth : String? = null;
    private var type : ClothType? = null;
    private var cost : Int? = null;
    private var isBought : Boolean? = null;
    private var isInInventory : Boolean? = null;
    private var isOrdered : Boolean? = null;
    private var isDeleted : Boolean? = null;
    private var imageID : Int? = null;

    init {
        this.cloth = cloth
        this.type = type
        this.cost = cost
        this.isBought = isBought
        this.isInInventory = isInInventory
        this.isOrdered = isOrdered
        this.isDeleted = isDeleted
    }


    fun setCloth(cloth : String?){this.cloth = cloth;}
    fun setType(type : ClothType?){this.type = type;}
    fun setCost(cost : Int?) {this.cost = cost;}
    fun setIsBought(isBought : Boolean?) {this.isBought = isBought;}
    fun setIsInInventory(isInInventory : Boolean?) {this.isInInventory = isInInventory;}
    fun setIsOrdered(isOrdered : Boolean?) {this.isOrdered = isOrdered; }
    fun setIsDeleted(isDeleted : Boolean?) {this.isDeleted = isDeleted;}

    fun getCloth(): String? {return this.cloth}
    fun getType(): ClothType? {return this.type}
    fun getCost(): Int? {return this.cost}
    fun getIsBought(): String? { return if (this.isBought!!) {"Megvásárolva"} else {"Nincs megvásárolva"}}
    fun getIsInInventory(): String? { return if (this.isInInventory!!) {"Raktáron"} else {"Nincs raktáron"}}
    fun getIsOrdered(): String? { return if (this.isOrdered!!) {"Megrendelve"} else {"Nincs megrendelve"}}
    fun getIsDeleted(): String? { return if (this.isDeleted!!) {"Törölve"} else {"Nincs törölve"}}
    fun getImageID() : Int? {return this.imageID}

}