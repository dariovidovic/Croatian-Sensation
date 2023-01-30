package com.example.croatiansensation

import android.database.SQLException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CocktailAdapter(private val cocktailList: ArrayList<Cocktails>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fav_cocktails,parent,false)
         return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) { is MyViewHolder -> { holder.bind(cocktailList[position]) } }

        if (position > 0) {
            val riskHolder: MyViewHolder = holder as MyViewHolder
            riskHolder.button.setOnClickListener(View.OnClickListener {
                try {
                    cocktailList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, itemCount)
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val strDrink : TextView = itemView.findViewById(R.id.strDrink)
        val strGlass : TextView = itemView.findViewById(R.id.strGlass)
        val strIngredients : TextView = itemView.findViewById(R.id.strIngredients)
        val strInstructions : TextView = itemView.findViewById(R.id.strInstructions)
        val strType : TextView = itemView.findViewById(R.id.strType)
        val button : Button = itemView.findViewById(R.id.deleteCocktail)
        fun bind(cocktails : Cocktails) {
            strDrink.text = cocktails.strDrink
            strGlass.text = cocktails.strGlass
            strIngredients.text = cocktails.strIngredients
            strInstructions.text = cocktails.strInstructions
            strType.text = cocktails.strType
        }

    }




}