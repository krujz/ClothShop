package com.example.clothshop.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothshop.models.ClothModel
import com.example.clothshop.R
import com.example.clothshop.Repository.ClothRepository
import com.example.clothshop.Utilities.ClothType
import com.example.clothshop.databinding.RecyclerItemClothModelBinding


class HomeFragment : Fragment() {

     var cloths : MutableList<String>? = mutableListOf()
    private  var types : MutableList<ClothType>? = mutableListOf()
    private  var costs : MutableList<Int>? = mutableListOf()
    private  var isBoughts : MutableList<Boolean>? = mutableListOf()
    private  var isIninventories : MutableList<Boolean>? = mutableListOf()
    private  var isOrdereds: MutableList<Boolean>? = mutableListOf()
    private  var isDeleteds : MutableList<Boolean> ? = mutableListOf()
    private  var imageID : MutableList<Int> ? = mutableListOf()
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
        val clothRepository = ClothRepository.getInstace()
        val typedArray = resources.obtainTypedArray(R.array.images)
        if (clothRepository!!.listofCloths!!.size == 0)
        {
            clothRepository!!.getCloths()
        }
        var i = 0
        while (i < clothRepository!!.listofCloths.size)
        {
            cloths!!.add(clothRepository.listofCloths[i].getCloth()!!)
            types!!.add(clothRepository.listofCloths[i].getType()!!)
            costs!!.add(clothRepository.listofCloths[i].getCost()!!)
            isBoughts!!.add(clothRepository.listofCloths[i].getIsBought()!!)
            isIninventories!!.add(clothRepository.listofCloths[i].getIsInInventory()!!)
            isOrdereds!!.add(clothRepository.listofCloths[i].getIsOrdered()!!)
            isDeleteds!!.add(clothRepository.listofCloths[i].getIsDeleted()!!)
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

        val view : View = inflater.inflate(R.layout.fragment_home,container,false)
        val activity = activity as Context
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.home_recycle_view)

        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        recyclerView.adapter = ClothsAdapter(activity)



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
            val cloth = ClothModel(cloths!![position],types!![position],costs!![position],isBoughts!![position],
                isIninventories!![position],isOrdereds!![position],isDeleteds!![position],imageID!![position])
            viewHolder.setData(cloth)
            viewHolder.itemView.setOnClickListener{ listener!!.onClothSelected(cloth) }
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