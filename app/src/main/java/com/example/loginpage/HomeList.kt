package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.*

@SuppressLint("Registered")
class HomeList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homelist)

        val listView = findViewById<ListView>(R.id.main_homeview)
//        val redColor = Color.parseColor("#FF0000")
//        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this) //this needs to be my custom adapter telling my list what to render
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter(){
        private val mContext: Context

        private val names = arrayListOf<String>(
            "Donald Trump", "Steve Jobs", "Tim Cook", "Emily", "Amelia", "Johannine", "LiPing", "Kimberly"
        )
        init {
            this.mContext = context
        }
        //responsible for num rows in list
        override fun getCount(): Int {
            return names.size
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        //ignore for now
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }
        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)

            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Row Number:$position"
            return rowMain
//            val textView = TextView(mContext)
//            textView.text = "HERE is my row for my LISTVIEW"
//            return textView
        }
    }
}
