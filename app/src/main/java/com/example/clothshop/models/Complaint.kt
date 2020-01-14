package com.example.clothshop.models

import com.example.clothshop.utilities.ClothType

class Complaint(id: Int?, text: String?, costumer: String?)
{
    private var id :Int? = null;
    private var text :String? = null
    private var costumer : String? = null

    init
    {
        this.id = id;
        this.text = text;
        this.costumer = costumer;
    }

    fun setid (id : Int?) {this.id = id}
    fun setText(text: String?){ this.text = text;}
    fun setCostumer(costumer: String?){ this.costumer = costumer;}

    fun getID() : Int?{return this.id;}
    fun getText() : String?{return this.text;}
    fun getCostumer() : String? {return this.costumer;}
}