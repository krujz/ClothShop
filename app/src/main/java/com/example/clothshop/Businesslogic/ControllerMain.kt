package com.example.clothshop.Businesslogic

import android.content.Context
import android.net.wifi.WifiManager
import com.example.clothshop.Repository.DataBaseQuerry
import com.example.clothshop.Repository.Enums.ServerState
import com.example.clothshop.Repository.SQLConnection

class ControllerMain : ControllerBase()
{
    companion object
    {
        private var instace : ControllerMain? = null;
        fun getInstace() : ControllerMain?
        {
            if ( instace == null)
            {
                instace = ControllerMain();
            }
            return instace;
        }
    }

    fun getDatabase(): DataBaseQuerry {
        return DataBaseQuerry.getInstance()!!;

    }

    override fun serverStatusWriter() {


        if (SQLConnection.getServerStatus() === ServerState.Online) {

            getLoginActivity()!!.LoginServerState!!.text = SQLConnection.getServerStatus().toString()
            getLoginActivity()!!.LoginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
            //fillDevelopmentState()
        } else {
            getLoginActivity()!!.LoginServerState!!.text = SQLConnection.getServerStatus().toString()
            getLoginActivity()!!.LoginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
        }



    }

    fun Starting() {
        val wifiManager =
            getLoginActivity()!!.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        connectSQL()
        serverStatusWriter()
    }

    fun connectSQL(): Boolean {
        val wifiManager =
            getLoginActivity()!!.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        return if (!SQLConnection.getServerStatus().equals(ServerState.Online)) {
            SQLConnection.ConnectToServer()
        } else {
            true
        }
    }
/*
    fun fillDevelopmentState() {
        getMainActivity().textViewDevelopmentState.setText(getDAO().getDeveloperMessages())
    }
    */
}