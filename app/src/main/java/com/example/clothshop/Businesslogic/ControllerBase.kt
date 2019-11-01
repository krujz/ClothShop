package com.example.clothshop.Businesslogic

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.clothshop.ui.Login.LoginActivity

abstract class  ControllerBase
{
    private lateinit var loginactivity : LoginActivity;
    protected var dialog: AlertDialog? = null

    fun setActivity(loginactivity: LoginActivity){
        this.loginactivity = loginactivity;
    }

    fun getLoginActivity() : LoginActivity?
    {
        return this.loginactivity;
    }

    fun MessageBox(uzenetSzoveg: String) {
        Toast.makeText(getLoginActivity()!!.getApplicationContext(), uzenetSzoveg, Toast.LENGTH_LONG)
            .show()
    }

    fun activityStarter(activityFrom: Context, activityTo: Class<*>) {
        val intent = Intent(activityFrom, activityTo)
        activityFrom.startActivity(intent)
    }

    abstract fun serverStatusWriter()

}