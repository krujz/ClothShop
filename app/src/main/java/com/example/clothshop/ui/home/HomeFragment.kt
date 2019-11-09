package com.example.clothshop.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothshop.Repository.ClothRepository
import com.example.clothshop.Utilities.ClothType
import com.example.clothshop.databinding.RecyclerItemClothModelBinding
import com.example.clothshop.models.ClothModel
import kotlinx.android.synthetic.main.fragment_cloth_item.*


class HomeFragment : Fragment() {

    private var ids :  MutableList<String>? = mutableListOf()
    private var cloths : MutableList<String>? = mutableListOf()
    private var types : MutableList<ClothType>? = mutableListOf()
    private var costs : MutableList<String>? = mutableListOf()
    private var timesOfBoughts : MutableList<String>? = mutableListOf()
    private var isIninventories : MutableList<String>? = mutableListOf()
    private var imageID : MutableList<Int> ? = mutableListOf()
    private val clothRepository = ClothRepository.getInstace()
    private var currenctcloth : ClothModel? = null
    private lateinit  var listener: OnClothSelected


    companion object
    {
        fun newInstance() : HomeFragment
        {
            return HomeFragment()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)


        if (context is OnClothSelected)
        {
            listener = context
        }
        else
        {
            throw Exception(context.toString() + " must implement onClothSelected")
        }

        val typedArray = resources.obtainTypedArray(com.example.clothshop.R.array.images)
        if (clothRepository!!.listofCloths!!.size == 0)
        {
            clothRepository!!.getCloths()
        }
        var i = 0
        while (i < clothRepository!!.listofCloths.size)
        {
            ids!!.add(""+ clothRepository.listofCloths[i].getId()!!)
            cloths!!.add(clothRepository.listofCloths[i].getCloth()!!)
            types!!.add(clothRepository.listofCloths[i].getType()!!)
            costs!!.add("" +clothRepository.listofCloths[i].getCost()!!)
            timesOfBoughts!!.add(""+clothRepository.listofCloths[i].getTimesOfBought()!!)
            isIninventories!!.add(clothRepository.listofCloths[i].getIsInInventory()!!)
            imageID!!.add(typedArray.getResourceId(clothRepository.getImageIdFromType(types!![i])!!, 0))
            i++
        }

        typedArray.recycle()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(com.example.clothshop.R.layout.fragment_home,container,false)
        val activity = activity as Context
        val recyclerView = view!!.findViewById<RecyclerView>(com.example.clothshop.R.id.home_recycle_view)


        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        recyclerView.adapter = ClothsAdapter(activity)

        var id = clothRepository!!.onChangeid
        if (id != null && cloths!!.size >= id!!)
        {
            cloths!![id] = clothRepository.listofCloths[id].getCloth()!!
            costs!![id] = clothRepository.listofCloths[id].getCost()!!.toString()
        }


        return view
    }


    internal inner class ClothsAdapter(context: Context?) : RecyclerView.Adapter<ViewHolder>()
    {
        private val layoutinflater = LayoutInflater.from(context
        )
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
            val recyclerDogModelBinding = RecyclerItemClothModelBinding
                .inflate(layoutinflater, parent, false)


            return ViewHolder(recyclerDogModelBinding.root, recyclerDogModelBinding)
        }

        override fun getItemCount(): Int {return cloths!!.size }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val cloth = ClothModel(ids!![position], cloths!![position],types!![position],costs!![position],timesOfBoughts!![position],
                isIninventories!![position],imageID!![position])
            viewHolder.setData(cloth)
            viewHolder.itemView.setOnClickListener{ listener!!.onClothSelected(cloth) }
            currenctcloth = cloth
        }
    }

    internal inner class ViewHolder constructor(itemView: View,
                                                private val recyclerItemClothListBinding:
                                                RecyclerItemClothModelBinding
    ) :
        RecyclerView.ViewHolder(itemView) {


        fun setData(clothmodel: ClothModel?) {
            recyclerItemClothListBinding!!.clothModel = clothmodel

        }
    }

    interface OnClothSelected {
        fun onClothSelected(clothmodel: ClothModel)
    }




}