package com.example.clothshop.businesslogic

import com.example.clothshop.models.Complaint
import com.example.clothshop.repository.ComplaintRepository
import com.example.clothshop.utilities.ClothType

class ControllerComplaint(complaintRepository: ComplaintRepository) : ControllerBase() {
    override fun serverStatusWriter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object
    {
        private var instace : ControllerComplaint? = null
        fun getInstace() : ControllerComplaint?
        {
            if (instace ==  null){instace = ControllerComplaint(ComplaintRepository.getInstace()!!)}
            return instace
        }
    }
    var complaintRepository : ComplaintRepository? = null
    init
    {
        this.complaintRepository = complaintRepository;
    }
    fun newComplaint(text : String, nameOfTheCustomer : String)
    {
        complaintRepository!!.newComplaint(text,nameOfTheCustomer )
    }

    fun getListofComplaints() : MutableList<Complaint>{return this.complaintRepository!!.getlistofComplaints()}

    fun makeComplaints()
    {
        try
        {
            val resultset = this.complaintRepository?.getComplaints()
            var addableComplaint: Complaint?
            val listofComplaints = mutableListOf<Complaint>()

            while (resultset!!.next()) {
               addableComplaint =
                   Complaint(resultset.getInt("id"),
                resultset.getString("Text"),
                resultset.getString("Costumer"))

                listofComplaints.add(addableComplaint)

            }

            complaintRepository!!.setlistofComplaints(listofComplaints)

        }
        catch (e : Exception){ }
        finally {complaintRepository!!.dispose()}
    }

}