package com.example.clothshop.Businesslogic

import android.text.TextUtils
import com.example.clothshop.Repository.RegistrationRepository

class ControllerRegistration(registrationRepository: RegistrationRepository) : ControllerBase()
{
    private var registrationRepository : RegistrationRepository? = null
    init
    {
        this.registrationRepository = registrationRepository;
    }

    companion object
    {
        private var instace : ControllerRegistration? = null;
        fun getInstace() : ControllerRegistration?
        {
            if ( instace == null)
            {
                instace = ControllerRegistration(RegistrationRepository());
            }
            return instace;
        }
    }

    override fun serverStatusWriter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }


    fun setRegistration(username : String?, password : String?,password_second : String?, email : String?) : Boolean
    {
        return if (password.equals(password_second) && email!!.isEmailValid()) registrationRepository!!.setRegistration(username!!,password!!,email) else false
    }
}