package com.example.clothshop.repository

import com.example.clothshop.models.Complaint
import java.sql.ResultSet

class ComplaintRepository :Database()
{

    var listofComplaints : MutableList<Complaint> = mutableListOf()

    fun getlistofComplaints() : MutableList<Complaint>{return this.listofComplaints}

    fun setlistofComplaints(listofComplaints : MutableList<Complaint>){this.listofComplaints = listofComplaints}

    companion object
    {
        private var instace : ComplaintRepository? = null
        fun getInstace() : ComplaintRepository?
        {
            if (instace ==  null){instace = ComplaintRepository()}
            return instace
        }
    }

    fun newComplaint(text : String,nameOfTheCustomer :String)
    {
        try
        {
            querry = "INSERT INTO [dbo].[Complaints] (Text,Costumer) VALUES ('$text','$nameOfTheCustomer')"
            runDatabseUpload(querry!!)
        }
        catch (e: Exception){MessageBox(e.message!!)}
    }
    fun getComplaints() : ResultSet?
    {
        return try {
            querry = "Select * FROM [dbo].[Complaints] "
            runDatabaseQuerry(querry!!)
            this.getResultSet()!!
        } catch (e: java.lang.Exception)
        {
            MessageBox(e.message!!)
            null
        }
    }
}