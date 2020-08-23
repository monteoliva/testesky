package br.com.monteoliva.testesky.view.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

import br.com.monteoliva.testesky.R

/**
 * Adapter for Item Image
 *
 * @author Claudio Monteoliva
 * @version 1.0.0
 * @since Aug-2020
 */
class ImageAdapter(private val backdropsUrl: MutableList<String>?) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = backdropsUrl!!.size
    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: String = getItem(position)

        holder.apply {
            Picasso.get()
                .load(item)
                .error(R.mipmap.ic_no_image)
                .into(imageItem)
        }
    }

    private fun getItem(position: Int): String = backdropsUrl!![position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageItem: ImageView = itemView.findViewById(R.id.imageItem)
    }
}