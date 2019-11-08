package com.example.clothshop.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.clothshop.R

class GalleryFragment : Fragment() {

    companion object
    {
        fun newInstance() : GalleryFragment
        {
            return GalleryFragment()
        }
    }
}