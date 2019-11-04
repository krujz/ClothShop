package com.example.clothshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clothshop.models.ClothModel
import com.example.clothshop.databinding.FragmentClothItemBinding

class HomeItemFragment : Fragment()
{
    companion object
    {
        private const val CLOTHMODEL = "model"

        fun newInstace(clothmodel : ClothModel) : HomeItemFragment
        {
            val args = Bundle()
            args.putSerializable(CLOTHMODEL, clothmodel)
            val fragment = HomeItemFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentClothitemBinding =
            FragmentClothItemBinding.inflate(inflater, container, false)

        val model = arguments!!.getSerializable(CLOTHMODEL) as ClothModel?
        fragmentClothitemBinding!!.clothModel = model

        return fragmentClothitemBinding.root
    }
}