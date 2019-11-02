package com.example.clothshop.Businesslogic

import com.example.clothshop.Models.Builders.ClothBuilder
import com.example.clothshop.Models.Cloths
import com.example.clothshop.Repository.ClothRepository
import com.example.clothshop.Utilities.ClothType

class ControllerCloth(clothrepository : ClothRepository?) : ControllerBase()
{
    var clothRepository : ClothRepository? = null;
    var clothBuilder : ClothBuilder? = null
    var cloths : Cloths? = null
    override fun serverStatusWriter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init
    {
        this.clothRepository =  clothrepository;
        this.clothBuilder = ClothBuilder();
        this.cloths = Cloths()
    }

    companion object
    {
        private var instace : ControllerCloth? = null
        fun getInstace() : ControllerCloth?
        {
            if( instace == null)
            {
                instace = ControllerCloth(ClothRepository());

            }
            return instace;
        }
    }

    fun getCloths() : Boolean
    {
        try
        {
            var resultset = this.clothRepository!!.getCloths();
            while (resultset!!.next())
            {
                cloths!!.addCloth(
                    clothBuilder!!.setCloth(resultset.getString("Cloth"))!!
                        .setType(ClothType.fromString(resultset.getString("Type")))!!
                        .setCost(resultset.getInt("Cost"))!!
                        .setIsBought(resultset.getBoolean("IsBought"))!!
                        .setIsInInventory(resultset.getBoolean("IsInInventory"))!!
                        .setIsOrdered(resultset.getBoolean("IsOrdered"))!!
                        .setDeleted(resultset.getBoolean("IsDeleted"))!!
                        .getClothBuilder())


            }
            return true
        }
        catch (e : Exception)
        {
            return false
        }
        finally
        {
            clothRepository!!.dispose()
        }

    }

}