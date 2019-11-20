package com.example.clothshop.repository

import java.lang.Exception

class RegistrationRepository :Database()
{
    fun setRegistration(username: String , password : String , email : String) : Boolean
    {
        return try
        {
            querry ="INSERT INTO [dbo].[Users] (username,password,email) VALUES ('$username','$password','$email');"
            runDatabseUpload(querry!!)
            true
        }
        catch (e : Exception){false}
    }
}