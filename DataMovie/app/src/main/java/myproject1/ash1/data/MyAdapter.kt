package myproject1.ash1.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import myproject1.ash1.data.model.Movie_responset
import myproject1.ash1.data.model.Results

data class MyAdapter(private val results:List<Results>): Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=results[position]
        holder.image.setImageResource(currentItem.hashCode())
        holder.txtdata.text= currentItem.toString()
        holder.txtover.text= currentItem.toString()
        holder.txtTitle.text= currentItem.toString()
        holder.txtvote.text= currentItem.toString()

    }

    override fun getItemCount(): Int {
        return results.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val image :ImageView=itemView.findViewById(R.id.imageView)
        val txtdata:TextView=itemView.findViewById(R.id.txtdata)
        val txtTitle:TextView=itemView.findViewById(R.id.txtTitle)
        val txtvote:TextView=itemView.findViewById(R.id.txtvote)
        val txtover:TextView=itemView.findViewById(R.id.textover)

    }


}
