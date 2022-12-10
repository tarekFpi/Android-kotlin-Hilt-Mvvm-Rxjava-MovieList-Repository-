package com.example.mykotlinrxjava.adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.view.Gravity.apply
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat.apply
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.repackaged.com.google.common.collect.Iterators.addAll
import com.example.mykotlinrxjava.R
import com.example.treding_games.model.GameItem
import com.squareup.picasso.Picasso
import javax.inject.Inject

class GameAdapter  constructor(private var context: Context ,private var arrayList: List<GameItem> )

                          :RecyclerView.Adapter<GameAdapter.MyviewHolder>(){

   /* private var arrayList: ArrayList<GameItem> = ArrayList()
    private lateinit var context: Context*/

    class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView_title: TextView = itemView.findViewById(R.id.text_title)

        val textView_genre: TextView = itemView.findViewById(R.id.text_genre)

        val textView_platform: TextView = itemView.findViewById(R.id.text_platform)

        val textView_Release_date: TextView = itemView.findViewById(R.id.text_Release_date)

        val imageview: ImageView = itemView.findViewById(R.id.imageview_game_url)

    }

    fun setData(gamelist: List<GameItem>)
    {
        this.arrayList= gamelist
        notifyDataSetChanged()
    }

  /*  fun setData(gamelist: List<GameItem>, context: Context) {
        this@GameAdapter.context = context
        arrayList.apply {
            notifyDataSetChanged()
            addAll(gamelist)
        }
    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        return MyviewHolder(LayoutInflater.from(context).inflate(R.layout.game_listview,parent,false))
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        var itemPosition = arrayList.get(position)

        holder.textView_title.setText(""+itemPosition.title)

        holder.textView_genre.setText(""+itemPosition.genre)

        holder.textView_platform.setText(""+itemPosition.platform)

        holder.textView_Release_date.setText("Release:"+itemPosition.release_date)

        Picasso.get().load(itemPosition.thumbnail).into(holder.imageview)

    }

    override fun getItemCount(): Int  = arrayList.size


}