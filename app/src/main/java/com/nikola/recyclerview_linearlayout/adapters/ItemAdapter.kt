package com.nikola.recyclerview_linearlayout.adapters

import android.text.TextUtils.indexOf
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikola.recyclerview_linearlayout.Item
import com.nikola.recyclerview_linearlayout.R

class ItemAdapter(
    private val items: List<Item>,
    private val listener: OnItemClickListener
    ) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()
{

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener
    {

        val imageView: ImageView = itemView.findViewById(R.id.image)
        val naslov: TextView = itemView.findViewById(R.id.tv_naslov)
        val opis: TextView = itemView.findViewById(R.id.tv_opis)

        init
        {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener
    {
        fun onItemClick(position: Int)
    }

    var list: MutableList<Item> = mutableListOf<Item>()

    fun deleteItem(pos: Int )
    {

        list.removeAt(pos)
        notifyItemRemoved(pos)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cv_list_items,parent,false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        val currentItem = items[position]

        holder.imageView.setImageResource(currentItem.image)
        holder.naslov.text = currentItem.title
        holder.opis.text = currentItem.description



    }

    override fun getItemCount() = items.size


}