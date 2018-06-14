package com.santhosh.mykotlin.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.santhosh.mykotlin.R

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val list = arrayListOf<String>(
                "Apple", "Banana", "Orange"
        )

        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = MyAdapter(this, list)

    }

    private class MyAdapter(context: Context, list: ArrayList<String>) : BaseAdapter() {

        private val mContext: Context;
        private val list: ArrayList<String>

        init {
            this.mContext = context;
            this.list = list
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false)
            val title = view.findViewById<TextView>(R.id.title)

            title.text = getItem(position)
            return view;
        }

        override fun getItem(position: Int): String {
            return list.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getCount(): Int {
            return list.size;
        }

    }
}
