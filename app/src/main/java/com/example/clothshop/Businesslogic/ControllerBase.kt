package com.example.clothshop.Businesslogic

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clothshop.ui.Login.LoginActivity

abstract class  ControllerBase
{
    private lateinit var activity : AppCompatActivity;
    protected var dialog: AlertDialog? = null

    fun setActivity(activity: AppCompatActivity){
        this.activity = activity;
    }

    fun getActivity() : AppCompatActivity?
    {
        return this.activity;
    }

    fun MessageBox(uzenetSzoveg: String) {
        Toast.makeText(getActivity()!!.getApplicationContext(), uzenetSzoveg, Toast.LENGTH_LONG)
            .show()
    }

    fun activityStarter(activityFrom: Context, activityTo: Class<*>) {
        val intent = Intent(activityFrom, activityTo)
        activityFrom.startActivity(intent)
    }

    abstract fun serverStatusWriter()

}