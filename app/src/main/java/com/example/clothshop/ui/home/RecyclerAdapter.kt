package com.example.clothshop.ui.home


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.clothshop.models.Cloth
import com.example.clothshop.R

class RecyclerAdapter(private val mContext: Context, cloth: MutableList<Cloth?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mcloth = mutableListOf<Cloth?>()


    init {
        mcloth = cloth
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_cloth_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull viewHolder: RecyclerView.ViewHolder, i: Int) {

        // Set the name of the 'NicePlace'
        (viewHolder as ViewHolder).mName.text = mcloth[i]!!.getCloth()

        /*
        // Set the image
        val defaultOptions = RequestOptions()
            .error(R.drawable.ic_launcher_background)
        Glide.with(mContext)
            .setDefaultRequestOptions(defaultOptions)
            .load(mcloth[i].getImageUrl())
            .into((viewHolder as ViewHolder).mImage)

         */
    }

    private inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {

         //val mImage: CircleImageView
         val mName: TextView

        init {
            //mImage = itemView.findViewById(R.id.image)
            mName = itemView.findViewById(R.id.cloth)
        }
    }
}