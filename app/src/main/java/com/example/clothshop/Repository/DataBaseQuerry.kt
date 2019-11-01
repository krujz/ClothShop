package com.example.clothshop.Repository

import java.lang.Exception

class DataBaseQuerry(): Database() {

    companion object
    {
        @Volatile private var instance : DataBaseQuerry? = null;

         fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: DataBaseQuerry().also { instance = it }
            }
    }

    fun getData() : String
    {
        try {
            querry = "SELECT TOP 1 message FROM [dbo].[table]";
            runDatabaseQuerry(querry!!);
            return getResultSet()!!.getString("message");

        }
        catch (ex : Exception)
        {

        }
        finally {
            dispose();
        }
        return "ss"
    }


}