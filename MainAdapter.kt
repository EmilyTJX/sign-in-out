package com.example.loginpage

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_row.view.*


class MainAdapter: RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {
    val videotitle = listOf("First title", "Second","1", "2","3","1", "2","3","1", "2","3")

    override fun getItemCount(): Int {
        return videotitle.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //to create a view
    val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videotitle= videotitle.get(position)
        holder.view.textView_videotitle.text = videotitle



//        holder.view.btn_color.setOnClickListener{
//        holder.view.setBackgroundColor(myBgColors[position])
//        holder.view.btn_color.setOnClickListener {
//            if (myBgColors[position] == Color.RED) {
//                myBgColors[position] = Color.GREEN
//            }
//            else if (myBgColors[position] == Color.GREEN) {
//                myBgColors[position] = Color.RED
//            }
//        }
        holder.view.btn_color.setOnClickListener(object : View.OnClickListener {
            var clicked = true
            override fun onClick(v: View) {
                clicked = if (!clicked) {
                    holder.view.btn_color.setBackgroundColor(Color.WHITE)
                    holder.view.btn_color.setTextColor(Color.BLACK)
                    true

                    //here i will update the database
                } else {
                    holder.view.btn_color.setBackgroundColor(Color.RED)
                    holder.view.btn_color.setTextColor(Color.WHITE)

                    false
                    //here i will update the database
                }
            }
        })
    }


class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){}
}