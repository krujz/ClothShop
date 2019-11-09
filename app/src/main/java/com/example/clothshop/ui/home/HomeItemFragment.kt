package com.example.clothshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.SpinnerAdapter
import androidx.fragment.app.Fragment
import com.example.clothshop.R
import com.example.clothshop.Repository.ClothRepository
import com.example.clothshop.databinding.FragmentClothItemBinding
import com.example.clothshop.models.Cloth
import com.example.clothshop.models.ClothModel


class HomeItemFragment : Fragment()
{
    private var btn_save : Button? = null
    private val clothRepository = ClothRepository.getInstace()
    var model : ClothModel? = null
    var editText_cloth : EditText? = null
    var editText_cost : EditText? = null

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

        model = arguments!!.getSerializable(CLOTHMODEL) as ClothModel?
        fragmentClothitemBinding!!.clothModel = model

        var view = fragmentClothitemBinding.root
        btn_save = view!!.findViewById(R.id.btn_save)
        editText_cloth = view!!.findViewById(R.id.cloth)
        editText_cost = view!!.findViewById(R.id.cost)

        btn_save!!.setOnClickListener {
            var cloth = editText_cloth!!.text.toString()
            var cost = editText_cost!!.text.toString()
            saveCurrentChanges(cloth,cost.toInt())
        }

        return fragmentClothitemBinding.root
    }
    fun saveCurrentChanges(cloth : String?, cost : Int?)
    {
        var id = model!!.id.toInt()
        clothRepository!!.setCloth(Cloth(id, cloth,null, cost,null,null))
    }

}