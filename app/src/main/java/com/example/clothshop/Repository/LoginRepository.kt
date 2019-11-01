package com.example.clothshop.Repository

class LoginRepository() : Database()
{

    fun IsLoginPassed(username : String, password : String): Boolean {
        try {

            querry =
                "SELECT username,password FROM [dbo].[Users] WHERE username LIKE '$username' AND password LIKE '$password'";
            runDatabaseQuerry(querry!!)
            getResultSet()!!.next();
            if (!getResultSet()!!.getString("username").equals(username)  &&
                !getResultSet()!!.getString("password").equals(password) )
            {
                return false;
            }

            return true
        } catch (ex: Exception) {
            return false
        } finally {
            dispose()
        }
    }

}