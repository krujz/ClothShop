package com.example.clothshop.userinterface.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothshop.businesslogic.ControllerCloth
import com.example.clothshop.repository.ClothRepository
import com.example.clothshop.utilities.ClothType
import com.example.clothshop.databinding.RecyclerItemClothModelBinding
import com.example.clothshop.models.Cloth
import com.example.clothshop.models.ClothModel


class HomeFragment : Fragment() {

    private var listofCloths : MutableList<Cloth>? = null
    private var ids :  MutableList<String>? = mutableListOf()
    private var cloths : MutableList<String>? = mutableListOf()
    private var types : MutableList<ClothType>? = mutableListOf()
    private var costs : MutableList<String>? = mutableListOf()
    private var timesOfBoughts : MutableList<String>? = mutableListOf()
    private var isIninventories : MutableList<String>? = mutableListOf()
    private var imageID : MutableList<Int> ? = mutableListOf()
    private val stocks : MutableList<Int?> = mutableListOf()
    private val orderCounts : MutableList<Int?> = mutableListOf()

    private var controllerCloth : ControllerCloth? = null

    private var currenctcloth : ClothModel? = null
    private lateinit  var listener: onClothSelected

    init
    {
        this.controllerCloth = ControllerCloth(ClothRepository.getInstace()!!)
        this.listofCloths = controllerCloth!!.getListOfCloths()
    }

    companion object{fun newInstance() : HomeFragment{return HomeFragment()}}

    override fun onAttach(context: Context?)
    {
        super.onAttach(context)

        if (context is onClothSelected){listener = context}

        if (listofCloths!!.size == 0)
        {
            controllerCloth!!.MakeCloths()
            this.listofCloths = controllerCloth!!.getListOfCloths()
        }

        divideFromListOfCloths()
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle? ): View?
    {
        val view : View = inflater.inflate(com.example.clothshop.R.layout.fragment_home,container,false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(com.example.clothshop.R.id.home_recycle_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        recyclerView.adapter = ClothsAdapter(activity)

        afterChangeCheckout()

        return view
    }

    private fun divideFromListOfCloths()
    {
        val typedArray = resources.obtainTypedArray(com.example.clothshop.R.array.images)
        var i = 0
        while (i < listofCloths!!.size)
        {
            ids!!.add(""+ listofCloths!![i].getId()!!)
            cloths!!.add(listofCloths!![i].getCloth()!!)
            types!!.add(listofCloths!![i].getType()!!)
            costs!!.add("" +listofCloths!![i].getCost()!!)
            timesOfBoughts!!.add(""+listofCloths!![i].getTimesOfBought()!!)
            isIninventories!!.add(listofCloths!![i].getIsInInventory()!!)
            imageID!!.add(typedArray.getResourceId(controllerCloth!!.getImageIdFromType(types!![i])!!, 0))
            stocks.add(listofCloths!![i].getStock())
            orderCounts.add(listofCloths!![i].getOrderCount())
            i++
        }

        typedArray.recycle()
    }

    private fun afterChangeCheckout()
    {
        var id = controllerCloth!!.onChangeid
        if (id != null && cloths!!.size >= id)
        {
            cloths!![id] = listofCloths!![id].getCloth()!!
            costs!![id] = listofCloths!![id].getCost()!!.toString()
        }
    }


    internal inner class ClothsAdapter(context: Context?) : RecyclerView.Adapter<ViewHolder>()
    {
        private val layoutinflater = LayoutInflater.from(context)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
            val recyclerDogModelBinding = RecyclerItemClothModelBinding.inflate(layoutinflater, parent, false)
            return ViewHolder(recyclerDogModelBinding.root, recyclerDogModelBinding)
        }

        override fun getItemCount(): Int {return cloths!!.size }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
        {
            val cloth = ClothModel(ids!![position], cloths!![position],types!![position],costs!![position],timesOfBoughts!![position],
                isIninventories!![position],imageID!![position],stocks[position].toString(),orderCounts[position].toString())

            viewHolder.setData(cloth)
            viewHolder.itemView.setOnClickListener{ listener.onClothSelected(cloth) }
            currenctcloth = cloth
        }
    }


    internal inner class ViewHolder (itemView: View,private val recyclerItemClothListBinding:RecyclerItemClothModelBinding) : RecyclerView.ViewHolder(itemView)
    {fun setData(clothmodel: ClothModel?) {recyclerItemClothListBinding.clothModel = clothmodel}}
}