package com.example.clothshop.userinterface.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clothshop.R

class IncomeFragment : Fragment() {


    companion object
    {
        fun newInstance() : IncomeFragment
        {
            return IncomeFragment()
        }
    }
    private lateinit var incomeViewModel: IncomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        incomeViewModel =
            ViewModelProviders.of(this).get(IncomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        incomeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}