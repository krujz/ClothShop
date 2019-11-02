package com.example.clothshop.Repository

import java.sql.ResultSet

class ClothRepository : Database()
{

    fun getCloths() : ResultSet?
    {
        try
        {
            querry = "Select * FROM [dbo].[Cloths]"
            runDatabaseQuerry(querry!!)

            return getResultSet()
        }
        catch (e : Exception)
        {
            return null;
        }
    }
}
