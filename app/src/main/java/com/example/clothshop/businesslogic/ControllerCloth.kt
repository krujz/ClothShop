package com.example.clothshop.businesslogic

import com.example.clothshop.models.Cloth
import com.example.clothshop.models.ClothModel
import com.example.clothshop.models.builders.ClothBuilder
import com.example.clothshop.repository.ClothRepository
import com.example.clothshop.utilities.ClothType

class ControllerCloth(clothRepository: ClothRepository) : ControllerBase() {
    override fun serverStatusWriter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object
    {
        private var instace : ControllerCloth? = null
        fun getInstace() : ControllerCloth?
        {
            if (instace ==  null){instace = ControllerCloth(ClothRepository.getInstace()!!)}
            return instace
        }
    }
    var clothRepository : ClothRepository? = null
    var onChangeid : Int? = null

    init {this.clothRepository = clothRepository}

    fun getListOfCloths() : MutableList<Cloth>{return this.clothRepository!!.getListOfCloths()}

    fun updateOrder(cloth : ClothModel, count : String?)
    {
        this.clothRepository!!.updateOrder(cloth,count)
        this.onChangeid = cloth!!.id!!.toInt()
        var changedcloth = this.clothRepository!!.listofCloths.first{ x->x.getId() == onChangeid}
        var i = this.clothRepository!!.listofCloths.indexOf(changedcloth)
        this.clothRepository!!.listofCloths[i].setOrderCount(count!!.toInt())
    }

    fun setCloth(cloth : Cloth?)
    {
        this.clothRepository!!.setCloth(cloth)
        this.onChangeid = cloth!!.getId()!!.minus(1)
        var changedcloth = this.clothRepository!!.listofCloths.first{ x->x.getId() == onChangeid}
        var i = this.clothRepository!!.listofCloths.indexOf(changedcloth)
        this.clothRepository!!.listofCloths[i].setCloth(cloth.getCloth())
        this.clothRepository!!.listofCloths[i].setCost(cloth.getCost())
    }

    fun MakeCloths()
    {
        try
        {
            val resultset = this.clothRepository?.getCloths()
            var addablecloth: Cloth?
            val clothBuilder = ClothBuilder()
            val listofCloths = mutableListOf<Cloth>()

            while (resultset!!.next()) {
                addablecloth = clothBuilder
                    .setId(resultset.getInt("id"))!!
                    .setCloth(resultset.getString("Cloth"))!!
                    .setType(ClothType.fromString(resultset.getString("Type")))!!
                    .setCost(resultset.getInt("Cost"))!!
                    .setTimesOfBought(resultset.getInt("Times_of_bought"))!!
                    .setIsInInventory(resultset.getBoolean("IsInInventory"))!!
                    .setStock(resultset.getInt("Stock"))!!
                    .setOrderCount(resultset.getInt("OrderCount"))!!
                    .getClothBuilder()

                listofCloths.add(addablecloth)

            }

            clothRepository!!.setListOfCloths(listofCloths)

        }
        catch (e : Exception){ }
        finally {clothRepository!!.dispose()}
    }

    fun calculateIncome(cost : Int, orderCount : Int) : Int
    {
        return cost*orderCount
    }


    fun getImageIdFromType(clothtype : ClothType?) : Int?
    {
        return when(clothtype) {
            ClothType.DRESS -> 0
            ClothType.SHIRT -> 1
            ClothType.SOCKS -> 2
            ClothType.SHOES -> 3
            ClothType.BELT -> 4
            ClothType.BRA -> 5
            ClothType.JUMPER -> 6
            ClothType.TROUSER -> 7
            else -> 8
        }
    }
}