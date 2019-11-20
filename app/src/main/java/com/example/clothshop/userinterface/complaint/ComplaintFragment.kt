package com.example.clothshop.userinterface.complaint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clothshop.R

class ComplaintFragment : Fragment() {

    companion object
    {
        fun newInstance() : ComplaintFragment
        {
            return ComplaintFragment()
        }
    }
    private lateinit var complaintViewModel: ComplaintViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        complaintViewModel =
            ViewModelProviders.of(this).get(ComplaintViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        complaintViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}