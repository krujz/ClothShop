package com.example.clothshop.Repository

import android.provider.ContactsContract
import java.lang.Exception

class RegistrationRepository :Database()
{
    fun setRegistration(username: String , password : String , email : String) : Boolean
    {
        try
        {
            querry =
                "INSERT INTO [dbo].[Users] (username,password,email) VALUES ('$username','$password','$email');"
            runDatabseUpload(querry!!)
            return true
        }catch (e : Exception)
        {
            return false
        }
    }
}