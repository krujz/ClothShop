package com.example.clothshop.repository

import java.sql.ResultSet

class LoginRepository() : Database()
{

    fun isLoginPassed(username : String, password : String): ResultSet?
    {
        try
        {
            querry ="SELECT username,password,email FROM [dbo].[Users] WHERE username LIKE '$username' AND password LIKE '$password'";
            runDatabaseQuerry(querry!!)

            return getResultSet()
        } catch (ex: Exception) {throw java.lang.Exception("Hiba az adatbázissal való kapcsolódás során")}
    }

}