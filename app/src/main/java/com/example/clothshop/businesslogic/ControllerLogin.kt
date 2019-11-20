package com.example.clothshop.businesslogic

import android.content.Context
import android.net.wifi.WifiManager
import com.example.clothshop.models.User
import com.example.clothshop.repository.enums.ServerState
import com.example.clothshop.repository.LoginRepository
import com.example.clothshop.repository.connection.SQLConnection
import com.example.clothshop.userinterface.Login.LoginActivity
import java.lang.Exception

class ControllerLogin(loginRepository : LoginRepository) : ControllerBase()
{
    private var loginRepository : LoginRepository? = null;

    init {this.loginRepository = loginRepository}

    companion object
    {
        private var instace : ControllerLogin? = null;
        fun getInstace() : ControllerLogin?
        {
            if ( instace == null){instace = ControllerLogin(LoginRepository())}
            return instace;
        }
    }
    override fun serverStatusWriter()
    {
        if (SQLConnection.getServerStatus() === ServerState.Online)
        {
            (getActivity() as LoginActivity).loginServerState!!.text = SQLConnection.getServerStatus().toString()
            (getActivity() as LoginActivity).loginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
        }
        else
        {
            (getActivity() as LoginActivity).loginServerState!!.text = SQLConnection.getServerStatus().toString()
            (getActivity() as LoginActivity).loginServerState!!.setTextColor(SQLConnection.getServerStatus().toColor())
        }
    }

    fun Starting()
    {
        val wifiManager = getActivity()!!.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        connectSQL()
        serverStatusWriter()
    }

    fun connectSQL(): Boolean
    {
        val wifiManager = getActivity()!!.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        return if (SQLConnection.getServerStatus() != ServerState.Online) {SQLConnection.ConnectToServer()} else {true}
    }

    fun IsLoginPassed(username : String, password : String) : Boolean
    {
        try
        {
            var loginResultSet = loginRepository!!.isLoginPassed(username,password)

            loginResultSet!!.next()
            if (loginResultSet.getString("username") == username &&
                loginResultSet.getString("password") == password)
            {
                User.getInstace()!!.setUsername(loginResultSet.getString("username"))
                return true
            }
            return false
        }
        catch (e : Exception){ return false }
        finally {loginRepository!!.dispose()}
    }
}