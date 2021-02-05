package cl.aulloa.dogapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cl.aulloa.dogapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailAdapter(val context: Context, private val list: List<String>) : RecyclerView.Adapter<DetailAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dogimg_list_item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bindItems(list[position], context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ImageHolder(item: View) : RecyclerView.ViewHolder(item){
        fun bindItems(name: String, context: Context) {
            val image = itemView.findViewById(R.id.dogImage) as ImageView
            Glide.with(context).load(name).centerCrop().placeholder(R.drawable.ic_dog_footprint).into(image)
        }
    }
}