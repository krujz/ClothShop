package com.example.clothshop.Models

class User(username : String?, email: String?)
{
    private var username :String? = null
    private var email :String? = null

    init
    {
        this.username = username;
        this.email = email;
    }

    fun setUsername(username: String?){ this.username = username;}
    fun setEmail(email: String?){ this.email = email;}

    fun getUsername() : String?{return this.username;}
    fun getEmail() : String? {return this.email;}
}