package com.example.clothshop.userinterface.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clothshop.R

class DeleteFragment : Fragment() {

    companion object
    {
        fun newInstance() : DeleteFragment
        {
            return DeleteFragment()
        }
    }
    private lateinit var deleteViewModel: DeleteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        deleteViewModel =
            ViewModelProviders.of(this).get(DeleteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_share, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)
        deleteViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}