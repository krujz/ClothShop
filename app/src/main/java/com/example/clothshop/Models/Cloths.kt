package com.example.clothshop.Models

class Cloths
{
    private var cloths : MutableList<Cloth?>? = null

    init
    {
      cloths = mutableListOf<Cloth?>();
    }

    fun getCloths() : MutableList<Cloth?>? { return this.cloths }

    fun addCloth(cloth : Cloth?){cloths!!.add(cloth);}

    fun removeCloth(cloth: Cloth?){cloths!!.remove(cloth);}
}