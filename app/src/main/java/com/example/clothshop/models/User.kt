package com.example.clothshop.models

class User()
{

    companion object
    {
        private var instace : User? = null
        fun getInstace() : User?
        {
            if (instace == null)
            {
                instace = User()
            }
            return instace;
        }
    }
    private var username :String? = null
    private var email :String? = null

    fun setUsername(username: String?){ this.username = username;}
    fun setEmail(email: String?){ this.email = email;}

    fun getUsername() : String?{return this.username;}
    fun getEmail() : String? {return this.email;}
}