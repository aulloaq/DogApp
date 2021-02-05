package cl.aulloa.dogapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.aulloa.dogapp.R

class HomeAdapter(private val list: List<String>, private val clickListener: OnClick) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
        holder.itemView.setOnClickListener {
            clickListener.click(list[position])
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
        var name: String = ""
        fun bindItems(name: String) {
            val textViewName = itemView.findViewById(R.id.txtName) as TextView
            textViewName.text = name
            this.name = name
        }
    }
}

interface OnClick{
    fun click(name: String)
}