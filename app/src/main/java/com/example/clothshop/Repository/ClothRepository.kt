package com.example.clothshop.Repository

import com.example.clothshop.models.builders.ClothBuilder
import com.example.clothshop.models.Cloth
import com.example.clothshop.Utilities.ClothType
import java.sql.ResultSet

class ClothRepository : Database()
{
    var clothBuilder : ClothBuilder? = null
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
    fun getImageIdFromType(clothtype: ClothType?) : Int?
    {
        when(clothtype)
        {
            ClothType.DRESS -> return 0
            ClothType.SHIRT -> return 1
            ClothType.SOCKS -> return 2
            ClothType.SHOES -> return 3
            ClothType.BELT -> return 4
            ClothType.BRA -> return 5
            ClothType.JUMPER -> return 6
            ClothType.TROUSER -> return 7
            else -> return 8
        }
    }
}
