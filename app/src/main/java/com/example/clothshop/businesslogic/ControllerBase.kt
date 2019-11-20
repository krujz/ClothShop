package com.example.clothshop.businesslogic

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class ControllerBase
{
    private lateinit var activity : AppCompatActivity;

    fun setActivity(activity: AppCompatActivity){this.activity = activity}

    fun getActivity() : AppCompatActivity?{return this.activity}

    fun MessageBox(uzenetSzoveg: String) {Toast.makeText(getActivity()!!.applicationContext, uzenetSzoveg, Toast.LENGTH_LONG).show()}

    fun activityStarter(activityFrom: Context, activityTo: Class<*>)
    {
        val intent = Intent(activityFrom, activityTo)
        activityFrom.startActivity(intent)
    }

    abstract fun serverStatusWriter()

}