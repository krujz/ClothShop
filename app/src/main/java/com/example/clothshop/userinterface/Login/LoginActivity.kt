package com.example.clothshop.userinterface.Login

import androidx.appcompat.app.AppCompatActivity
import com.example.clothshop.R
import kotlinx.android.synthetic.main.activity_login.*
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.clothshop.businesslogic.ControllerLogin
import com.example.clothshop.models.User
import com.example.clothshop.userinterface.MainActivity
import com.example.clothshop.userinterface.Registration.RegistrationActivity

class LoginActivity: AppCompatActivity()
{
    var editTextUsername: EditText? = null;
    var editTextPassword: EditText? = null;
    var loginServerState: TextView? = null;

    private var controllerLogin: ControllerLogin? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextPassword = findViewById(R.id.password)
        editTextUsername = findViewById(R.id.username)
        loginServerState = findViewById(R.id.loginserverstate)
        controllerLogin = ControllerLogin.getInstace()
        controllerLogin!!.setActivity(this)
        controllerLogin!!.Starting()
        login.setOnClickListener {

          if(controllerLogin!!.IsLoginPassed(editTextUsername!!.text.toString(),editTextPassword!!.text.toString()))
            {
                controllerLogin!!.activityStarter(this,MainActivity::class.java)
                controllerLogin!!.MessageBox( "Üdvözöllek " + User.getInstace()!!.getUsername())
            }
            else
            {
                editTextPassword!!.text.clear()
                editTextUsername!!.text.clear()
                controllerLogin!!.MessageBox("Sikertelen bejelentkezés")
            }
        }
        signup.setOnClickListener {

            controllerLogin!!.activityStarter(this,RegistrationActivity::class.java)
        }
    }

}