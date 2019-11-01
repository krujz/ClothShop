package com.example.clothshop.Businesslogic

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.clothshop.MainActivity

abstract class  ControllerBase
{
    private lateinit var mainActivity : MainActivity;
    protected var dialog: AlertDialog? = null

    fun setMainActivity(mainActivity: MainActivity){
        this.mainActivity = mainActivity;
    }

    fun getMainActivity() : MainActivity?
    {
        return this.mainActivity;
    }

    fun MessageBox(uzenetSzoveg: String) {
        Toast.makeText(getMainActivity()!!.getApplicationContext(), uzenetSzoveg, Toast.LENGTH_LONG)
            .show()
    }

    fun activityStarter(activityFrom: Context, activityTo: Class<*>) {
        val intent = Intent(activityFrom, activityTo)
        activityFrom.startActivity(intent)
    }

    abstract fun serverStatusWriter()

}