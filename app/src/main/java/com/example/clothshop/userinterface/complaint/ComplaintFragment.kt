package com.example.clothshop.userinterface.complaint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.clothshop.R
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.clothshop.businesslogic.ControllerComplaint
import com.example.clothshop.repository.ComplaintRepository


class ComplaintFragment : Fragment() {

    var controllerComplaint : ControllerComplaint? = null
    init {
        this.controllerComplaint = ControllerComplaint(ComplaintRepository.getInstace()!!)
    }
    companion object
    {
        fun newInstance() : ComplaintFragment
        {
            return ComplaintFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_complaint, container, false)

        var complaintText = root.findViewById<TextView>(R.id.autofittextview)
        var editTextComplaint = root.findViewById<EditText>(R.id.text_complaint)
        var editTextCustomer = root.findViewById<EditText>(R.id.nameOfTheCustomer)
        var btnSendin = root.findViewById<Button>(R.id.btnsendin)


        editTextComplaint.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
                // do nothing
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
                complaintText.text = charSequence
            }

            override fun afterTextChanged(editable: Editable) {
                // do nothing
            }
        })

        btnSendin.setOnClickListener{

            controllerComplaint!!.newComplaint(complaintText.text.toString(),editTextCustomer.text.toString())

            Toast.makeText(activity!!.applicationContext, "Sikeres mentés", Toast.LENGTH_LONG).show()
            complaintText.text = ""
            editTextComplaint.setText("")
            editTextCustomer.setText("")
        }

        return root
    }
}