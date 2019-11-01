package com.example.clothshop.Repository

import java.lang.Exception

class DataBaseQuerry : Database() {

    companion object
    {
        private var instance : DataBaseQuerry? = null;
        fun getInstance() : DataBaseQuerry?
        {
            if ( instance == null)
            {
                instance = DataBaseQuerry();
            }
            return instance;
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