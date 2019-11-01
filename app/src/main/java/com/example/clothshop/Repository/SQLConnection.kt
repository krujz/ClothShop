package com.example.clothshop.Repository

import android.annotation.SuppressLint
import android.os.StrictMode
import com.example.clothshop.Repository.Enums.ServerState
import java.sql.DriverManager

class SQLConnection
{
    companion object {
        var conDatabase: java.sql.Connection? = null


        fun ConnectToServer(): Boolean {
            return connectToDataBase() == ServerState.Online
        }


        @SuppressLint("NewApi")
        fun connectToDataBase(): ServerState {

            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
                conDatabase =
                    //"jdbc:jtds:sqlserver://192.168.1.9;database=msss;instance=SQLEXPRESS;Network Protocol=NamedPipes" ;
                    //jdbc:sqlserver://PC01\inst01;databaseName=DB01;integratedSecurity=true
                    DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.16;databaseName=AndroidProject;user=sa;password=Hungaria5;integratedSecurity=true;loginTimeout=5;socketTimeout=5")



                return ServerState.Online
            } catch (e: Exception) {
                return ServerState.Offline
            }

        }


        fun getServerStatus(): ServerState {
            try {
                return if (!conDatabase!!.isClosed) {
                    ServerState.Online
                } else {
                    ServerState.Offline
                }
            } catch (ex: Exception) {
                return ServerState.Offline
            }

        }
    }

}