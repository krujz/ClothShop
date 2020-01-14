package com.example.clothshop.userinterface.complaintlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothshop.businesslogic.ControllerComplaint
import com.example.clothshop.databinding.RecyclerComplaintItemBinding
import com.example.clothshop.models.Complaint
import com.example.clothshop.models.ComplaintModel

class ComplaintListFragment : Fragment() {

    private var listOfComplaints : MutableList<Complaint>? = null
    private var ids : MutableList<String>? = mutableListOf()
    private var texts : MutableList<String>? = mutableListOf()
    private var costumers : MutableList<String>? = mutableListOf()
    private var controllerComplaint : ControllerComplaint? = null

    companion object {fun newInstance() : ComplaintListFragment {return ComplaintListFragment()}}

    init
    {
        this.controllerComplaint = ControllerComplaint.getInstace()
        this.listOfComplaints = controllerComplaint!!.getListofComplaints()
    }

    override fun onAttach(context: Context?)
    {
        super.onAttach(context)


        controllerComplaint!!.makeComplaints()
        this.listOfComplaints = controllerComplaint!!.getListofComplaints()


        dividefRomListOfComlaints()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        val view : View = inflater.inflate(com.example.clothshop.R.layout.fragment_complaintlist,container,false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(com.example.clothshop.R.id.home_recycle_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        recyclerView.adapter = ComplaintAdatper(activity)

        return view
    }

    private fun dividefRomListOfComlaints()
    {
        var i = 0
        while (i < listOfComplaints!!.size)
        {
            ids!!.add(""+ listOfComplaints!![i].getID()!!)
            texts!!.add(listOfComplaints!![i].getText()!!)
            costumers!!.add("" +listOfComplaints!![i].getCostumer()!!)
            i++
        }
    }

    internal inner class ComplaintAdatper(context: Context?) : RecyclerView.Adapter<ViewHolder>()
    {
        private val layoutinflater = LayoutInflater.from(context)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
            val recyclerComplaintModelBinding = RecyclerComplaintItemBinding.inflate(layoutinflater, parent, false)
            return ViewHolder(recyclerComplaintModelBinding.root, recyclerComplaintModelBinding)
        }

        override fun getItemCount(): Int {return ids!!.size }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
        {
            val complaint = ComplaintModel(ids!![position],texts!![position],costumers!![position])

            viewHolder.setData(complaint)
        }
    }


    internal inner class ViewHolder (itemView: View,private val recyclerItemComplaintListBinding:RecyclerComplaintItemBinding) : RecyclerView.ViewHolder(itemView){
    fun setData(complaintModel: ComplaintModel?) {recyclerItemComplaintListBinding.complaintModel = complaintModel}}

}