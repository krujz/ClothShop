package com.example.clothshop.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clothshop.Models.Builders.ClothBuilder
import com.example.clothshop.Models.Cloth
import com.example.clothshop.Utilities.ClothType
import java.sql.ResultSet

class ClothRepository : Database()
{
    var clothBuilder : ClothBuilder? = null
    var listofCloths : MutableList<Cloth?>? = null

    val mutablelivedata_cloths = MutableLiveData<MutableList<Cloth?>?>()
    //val livedata_cloths : LiveData<MutableList<Cloth?>?>
      //  get() = mutablelivedata_cloths

    init
    {
        this.clothBuilder = ClothBuilder();
        listofCloths = mutableListOf()
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
                listofCloths!!.add(
                    clothBuilder!!.setCloth(resultset.getString("Cloth"))!!
                        .setType(ClothType.fromString(resultset.getString("Type")))!!
                        .setCost(resultset.getInt("Cost"))!!
                        .setIsBought(resultset.getBoolean("IsBought"))!!
                        .setIsInInventory(resultset.getBoolean("IsInInventory"))!!
                        .setIsOrdered(resultset.getBoolean("IsOrdered"))!!
                        .setDeleted(resultset.getBoolean("IsDeleted"))!!
                        .getClothBuilder())
            }
            mutablelivedata_cloths.value = listofCloths;

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
