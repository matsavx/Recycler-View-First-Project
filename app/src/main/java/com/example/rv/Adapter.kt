package com.example.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv.databinding.ItemSampleBinding

class Adapter: RecyclerView.Adapter<Adapter.Holder>() {

    class Holder(item: View): RecyclerView.ViewHolder(item) {
        val connecting = ItemSampleBinding.bind(item)
        fun connect(sneakers: Sneakers) {
            connecting.imageViewId.setImageResource(sneakers.img_id)
            connecting.titleViewId.text = sneakers.title
            connecting.priceViewId.text = sneakers.price
        }
    }

    val sneakers_list = ArrayList<Sneakers>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sample, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.connect(sneakers_list[position])
    }

    override fun getItemCount(): Int {
        return sneakers_list.size
    }

    fun addItem(sneakers: Sneakers) {
        sneakers_list.add(sneakers)
        notifyDataSetChanged()
    }
}