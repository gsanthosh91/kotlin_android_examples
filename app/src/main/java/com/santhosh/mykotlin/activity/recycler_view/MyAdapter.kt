package com.santhosh.mykotlin.activity.recycler_view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santhosh.mykotlin.R
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

/**
 * Created by santhosh@appoets.com on 14-06-2018.
 */
class MyAdapter(private val list: List<RecyclerViewActivity.Video>) : RecyclerView.Adapter<MyAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(rowView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: MyAdapter.CustomViewHolder, position: Int) {
        val video = list.get(position)
        holder.view.title.text = video.name
    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}
