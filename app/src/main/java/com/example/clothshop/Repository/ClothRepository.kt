package com.example.clothshop.Repository

import com.example.clothshop.models.builders.ClothBuilder
import com.example.clothshop.models.Cloth
import com.example.clothshop.Utilities.ClothType
import java.sql.ResultSet

class ClothRepository : Database()
{
    var clothBuilder : ClothBuilder? = null
    var sizeofArray : Int = 0
    var  listofCloths : MutableList<Cloth>
    var addablecloth : Cloth? = null

    init
    {
        listofCloths = mutableListOf<Cloth>()
        clothBuilder = ClothBuilder()
    }

    companion object
    {
        private var instace : ClothRepository? = null
        fun getInstace() : ClothRepository?
        {
            if (instace ==  null){instace = ClothRepository()}
            return instace
        }
    }

    fun setCloth(cloth : Cloth?)
    {
        try
        {
            querry = "INSERT INTO [dbo].[Cloths] (Cloth,Type,Cost,IsBought,IsInInventory,IsOrdered, IsDeleted) " +
                    "values (${cloth!!.getCloth()},${cloth!!.getType().toString()},${cloth!!.getCost()},0,1,0,0)"
            runDatabseUpload(querry!!)
        }
        catch (e: Exception){{}}
    }

    fun getCloths()
    {
        try
        {
            querry = "Select * FROM [dbo].[Cloths]"
            runDatabaseQuerry(querry!!)

            this.MakeCloths(getResultSet()!!)
        }
        catch (e : Exception){}
    }

    fun MakeCloths(resultset: ResultSet)
    {
        try
        {


            while (resultset!!.next())
            {
                addablecloth = clothBuilder!!.setCloth(resultset.getString("Cloth"))!!
                        .setType(ClothType.fromString(resultset.getString("Type")))!!
                        .setCost(resultset.getInt("Cost"))!!
                        .setIsBought(resultset.getBoolean("IsBought"))!!
                        .setIsInInventory(resultset.getBoolean("IsInInventory"))!!
                        .setIsOrdered(resultset.getBoolean("IsOrdered"))!!
                        .setDeleted(resultset.getBoolean("IsDeleted"))!!
                        .getClothBuilder()!!

                listofCloths.add(addablecloth!!)

            }



/*

            var cloth = Cloth()
            cloth.setCloth("ss")
            cloth.setType(ClothType.DRESS)
            cloth.setCost(1000)
            cloth.setIsBought(false)
            cloth.setIsInInventory(false)
            cloth.setIsOrdered(false)
            cloth.setIsDeleted(false)

 */




            //mutablelivedata_cloths.value = listofCloths;

        }
        catch (e : Exception)
        {
            {}
        }
        finally
        {
            this.dispose()
        }
    }

    fun ConvertBitToBoolean()
    {

    }
}
