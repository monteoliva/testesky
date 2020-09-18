package br.com.monteoliva.testesky.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

import br.com.monteoliva.testesky.model.gson.Item
import br.com.monteoliva.testesky.R
import br.com.monteoliva.testesky.view.main.MainActivity

/**
 * Adapter for Item List
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class ItemAdapter(private val activity: MainActivity,
                  private val list: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(this, view)
    }

    override fun getItemCount(): Int = list.size
    override fun getItemId(position: Int): Long = list[position].id!!.toLong()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Item = getItem(position)

        holder.apply {
            itemTitle.text = item.title

            Picasso.get()
                .load(item.coverUrl)
                .error(R.mipmap.ic_no_image)
                .into(itemImage)
        }
    }

    private fun getItem(position: Int): Item = list[position]

    fun detail(item: Item) { activity.detail(item) }

    class ViewHolder(itemAdapter: ItemAdapter, itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView    = itemView.findViewById(R.id.itemTitle)
        val itemImage: ImageView   = itemView.findViewById(R.id.itemImage)
        val itemCard: LinearLayout = itemView.findViewById(R.id.itemCard)

        init {
            itemCard.setOnClickListener {
                val item: Item = itemAdapter.getItem(adapterPosition)
                itemAdapter.detail(item)
            }
        }
    }
}