package com.e.basicrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val itemList: List<Item>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){

        lateinit var itemImage: ImageView
        lateinit var itemName: TextView
        lateinit var itemShortDesc: TextView

        fun init(){
            itemImage = view.findViewById(R.id.IV_item_image)
            itemName = view.findViewById(R.id.TV_item_name)
            itemShortDesc = view.findViewById(R.id.TV_item_short_desc)

        }
        fun bind(item: Item?){
            init()

            itemShortDesc.text = item?.itemShortDesc
            itemName.text = item?.itemName

            Glide.with(view)
                .load(item?.itemImage)
                .into(itemImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, null, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}