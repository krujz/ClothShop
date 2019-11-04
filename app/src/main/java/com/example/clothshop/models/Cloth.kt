package com.example.clothshop.models

import com.example.clothshop.Utilities.ClothType

class Cloth()
{
    private var cloth : String? = null;
    private var type : ClothType? = null;
    private var cost : Int? = null;
    private var isBought : Boolean? = null;
    private var isInInventory : Boolean? = null;
    private var isOrdered : Boolean? = null;
    private var isDeleted : Boolean? = null;


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
    fun getIsBought(): Boolean? {return this.isBought}
    fun getIsInInventory(): Boolean? {return this.isInInventory}
    fun getIsOrdered(): Boolean? {return this.isOrdered}
    fun getIsDeleted(): Boolean? {return this.isDeleted}

}