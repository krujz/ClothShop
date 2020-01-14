package com.example.clothshop.repository

import android.app.PendingIntent.getActivity
import android.widget.Toast
import com.example.clothshop.models.Cloth
import com.example.clothshop.models.ClothModel
import com.example.clothshop.userinterface.MainActivity
import java.sql.ResultSet

class ClothRepository : Database()
{
    var listofCloths : MutableList<Cloth> = mutableListOf()

    fun getListOfCloths() : MutableList<Cloth>{return this.listofCloths}

    fun setListOfCloths(listofcloths : MutableList<Cloth>){this.listofCloths = listofcloths}

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
            querry = "UPDATE [dbo].[Cloth] SET Cloth='${cloth!!.getCloth()}',Cost=${cloth.getCost()} WHERE id= ${cloth.getId()}"
            runDatabseUpload(querry!!)
        }
        catch (e: Exception){MessageBox(e.message!!)}
    }

    fun getCloths() : ResultSet?
    {
        return try
        {
            querry = "Select * FROM [dbo].[Cloth] ORDER BY Times_of_bought DESC "
            runDatabaseQuerry(querry!!)
            this.getResultSet()!!

        } catch (e : Exception)
        {
            MessageBox(e.message!!)
            return null
        }
    }

    fun updateOrder(cloth : ClothModel, count : String?)
    {
        try
        {
            querry = "UPDATE [dbo].[Cloth] set OrderCount = $count WHERE id = ${cloth.id}"
            runDatabseUpload(querry!!)

        }
        catch (e: Exception){MessageBox(e.message!!)}
    }
}
