package com.example.clothshop.Models.Builders

import com.example.clothshop.Models.User

class UserBuilder
{
    private var username :String? = null
    private var email :String? = null

    fun setUserName(username :String?) : UserBuilder?
    {
        this.username = username;
        return this;
    }

    fun setEmail(email : String?) : UserBuilder?
    {
        this.email = email;
        return this;
    }

    fun getUserBuilder() : User? {return User(username,email);}

}