package com.santhosh.mykotlin.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.santhosh.mykotlin.R
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.list_item.view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val list = arrayListOf<String>(
                "Apple", "Banana", "Orange"
        )

        list_view.adapter = MyAdapter(this, list)

    }

    private class MyAdapter(context: Context, list: ArrayList<String>) : BaseAdapter() {

        private val mContext: Context;
        private val list: ArrayList<String>

        init {
            this.mContext = context;
            this.list = list
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View

            if (convertView == null) {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false)
                view.tag = ViewHolder(view.title, view.description)
            } else {
                view = convertView
            }

            val viewHolder = view.tag as ViewHolder

            viewHolder.title.text = getItem(position)

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

        private class ViewHolder(val title: TextView, val description: TextView) {

        }

    }
}
