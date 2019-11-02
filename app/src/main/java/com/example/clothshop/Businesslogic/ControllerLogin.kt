package com.example.clothshop.Businesslogic

import android.content.Context
import android.net.wifi.WifiManager
import com.example.clothshop.Repository.DataBaseQuerry
import com.example.clothshop.Repository.Enums.ServerState
import com.example.clothshop.Repository.LoginRepository
import com.example.clothshop.Repository.SQLConnection
import com.example.clothshop.ui.Login.LoginActivity
import com.example.clothshop.ui.Registration.RegistrationActivity
import java.lang.Exception
import kotlin.math.log

class ControllerLogin(loginRepository : LoginRepository) : ControllerBase()
{
    private var loginRepository : LoginRepository? = null;

    init
    {
        this.loginRepository = loginRepository;
    }

    companion object
    {
        private var instace : ControllerLogin? = null;
        fun getInstace() : ControllerLogin?
        {
            if ( instace == null)
            {
                instace = ControllerLogin(LoginRepository());
            }
            return instace;
        }
    }

    fun getDatabase(): DataBaseQuerry {
        return DataBaseQuerry.getInstance()!!;

    }

    override fun serverStatusWriter() {


        if (SQLConnection.getServerStatus() === ServerState.Online) {

            (getActivity() as LoginActivity)!!.loginServerState!!.text = SQLConnection.getServerStatus().toString()
            (getActivity() as LoginActivity)!!.loginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
        } else {
            (getActivity() as LoginActivity)!!.loginServerState!!.text = SQLConnection.getServerStatus().toString()
            (getActivity() as LoginActivity)!!.loginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
        }



    }

    fun Starting() {
        val wifiManager =
            getActivity()!!.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        connectSQL()
        serverStatusWriter()
    }

    fun connectSQL(): Boolean {
        val wifiManager =
            getActivity()!!.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        return if (!SQLConnection.getServerStatus().equals(ServerState.Online)) {
            SQLConnection.ConnectToServer()
        } else {
            true
        }
    }

    fun IsLoginPassed(username : String, password : String) : Boolean
    {
        try {
            var loginResultSet = loginRepository!!.IsLoginPassed(username,password)
            loginResultSet!!.next()
            return (loginResultSet!!.getString("username").equals(username)  &&
                    loginResultSet!!.getString("password").equals(password) )
        }
        catch (e : Exception)
        {
            return false
        }
        finally {
            loginRepository!!.dispose()
        }
    }
}