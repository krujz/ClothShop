package com.example.clothshop.userinterface.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.clothshop.R
import com.example.clothshop.businesslogic.ControllerCloth
import com.example.clothshop.repository.ClothRepository
import com.example.clothshop.databinding.FragmentClothItemBinding
import com.example.clothshop.models.Cloth
import com.example.clothshop.models.ClothModel


class HomeItemFragment : Fragment()
{
    private var btnSave : Button? = null
    private var btnOrder : Button? = null
    private var model : ClothModel? = null
    private var edittextCloth : EditText? = null
    private var edittextCost : EditText? = null
    private var edittextCount : EditText? = null
    private var controllerCloth : ControllerCloth = ControllerCloth(ClothRepository.getInstace()!!)

    companion object
    {
        private const val CLOTHMODEL = "model"

        fun newInstace(clothmodel : ClothModel) : HomeItemFragment
        {
            val args = Bundle()
            val fragment = HomeItemFragment()

            args.putSerializable(CLOTHMODEL, clothmodel)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        val fragmentClothitemBinding = FragmentClothItemBinding.inflate(inflater, container, false)

        model = arguments!!.getSerializable(CLOTHMODEL) as ClothModel?
        fragmentClothitemBinding.clothModel = model

        var view = fragmentClothitemBinding.root
        btnSave = view.findViewById(R.id.btn_save)
        btnOrder = view.findViewById(R.id.btn_order)
        edittextCloth = view.findViewById(R.id.cloth)
        edittextCost = view.findViewById(R.id.cost)
        edittextCount = view.findViewById(R.id.count)

        btnSave!!.setOnClickListener {
            var cloth = edittextCloth!!.text.toString()
            var cost = edittextCost!!.text.toString()
            saveCurrentChanges(cloth,cost.toInt())
        }

        btnOrder!!.setOnClickListener {setNewOrder()}

        return fragmentClothitemBinding.root
    }
    private fun saveCurrentChanges(cloth : String?, cost : Int?)
    {
        var id = model!!.id.toInt()
        controllerCloth.setCloth(Cloth(id, cloth,null, cost,null,null, null,null))
        saveMessage()
    }

    private fun setNewOrder()
    {
        var count = edittextCount!!.text.toString()
        val dialogBuilder = AlertDialog.Builder(activity!!)
        dialogBuilder.setTitle("Biztos rendelni szeretnél?")
        dialogBuilder.setMessage("A rendelt mennyiség :$count")
            .setCancelable(true)
            .setNegativeButton("Mégse") { dialog, _ -> dialog.dismiss()  }
            .setPositiveButton("Ok")
            { _, _ ->
                controllerCloth.updateOrder(model!!,count)
                Toast.makeText(activity!!.applicationContext, "A rendelés sikeres volt", Toast.LENGTH_LONG).show()
                edittextCount!!.text.clear()
            }

        val alert = dialogBuilder.create()
        alert.show()
    }

    private fun saveMessage()
    {
        val dialogBuilder = AlertDialog.Builder(activity!!)
        dialogBuilder.setMessage("A mentés sikeres volt")
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, _ -> dialog.dismiss()}

        val alert = dialogBuilder.create()
        alert.show()
    }

}