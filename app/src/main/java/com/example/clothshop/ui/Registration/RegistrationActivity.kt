package com.example.clothshop.ui.Registration

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.clothshop.Businesslogic.ControllerLogin
import com.example.clothshop.Businesslogic.ControllerRegistration
import com.example.clothshop.R
import com.example.clothshop.Repository.LoginRepository
import com.example.clothshop.ui.Login.LoginActivity

class RegistrationActivity : AppCompatActivity() {

    var editTextUsername: EditText? = null;
    var editTextEmail: EditText? = null;
    var editTextPassword: EditText? = null;
    var editTextPassword_second_time: EditText? = null;
    var btnRegistrate : Button? = null;
    var controllerRegistration : ControllerRegistration? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        editTextUsername = findViewById(R.id.username)
        editTextEmail = findViewById(R.id.Email)
        editTextPassword = findViewById(R.id.password)
        editTextPassword_second_time = findViewById(R.id.password_second_time)
        btnRegistrate = findViewById(R.id.registrate)
        controllerRegistration = ControllerRegistration.getInstace();
        controllerRegistration!!.setActivity(this)

        btnRegistrate!!.setOnClickListener()
        {
            if(controllerRegistration!!.setRegistration(editTextUsername!!.text.toString(),editTextPassword!!.text.toString(),
                                                    editTextPassword_second_time!!.text.toString(),editTextEmail!!.text.toString()))
            {
                controllerRegistration!!.activityStarter(this,LoginActivity::class.java)
                controllerRegistration!!.MessageBox("Sikeres regisztráció")
            }
            else
            {
                controllerRegistration!!.MessageBox("Sikertelen regisztráció")
            }
        }

    }
}