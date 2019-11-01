package com.example.clothshop.ui.Login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.clothshop.R
import kotlinx.android.synthetic.main.activity_login.*
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.clothshop.Businesslogic.ControllerMain
import com.example.clothshop.Repository.LoginRepository
import com.example.clothshop.ui.MainActivity

class LoginActivity: AppCompatActivity()
{
    var editTextUsername: EditText? = null;
    var editTextPassword: EditText? = null;
    var LoginServerState: TextView? = null;
    var loginRepository : LoginRepository? = null;
    private var controllerMain: ControllerMain? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextPassword = findViewById(R.id.password)
        editTextUsername = findViewById(R.id.username)
        LoginServerState = findViewById(R.id.loginserverstate)
        controllerMain = ControllerMain.getInstace();
        controllerMain!!.setActivity(this);
        controllerMain!!.Starting();
        login.setOnClickListener {

            loginRepository = LoginRepository()
            if(loginRepository!!.IsLoginPassed(editTextUsername!!.text.toString(),editTextPassword!!.text.toString()))
            {
                val intent = Intent(this,MainActivity::class.java);
                this.startActivity(intent);
            }
            else
            {
                editTextPassword!!.setText("");
                editTextUsername!!.setText("");
            }


        }
    }

}