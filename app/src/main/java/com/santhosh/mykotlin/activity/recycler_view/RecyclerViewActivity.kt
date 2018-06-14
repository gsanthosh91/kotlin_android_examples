package com.santhosh.mykotlin.activity.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.santhosh.mykotlin.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import okhttp3.*
import java.io.IOException

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }

    private fun fetchJson() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recycler_view.adapter = MyAdapter(homeFeed.videos)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to excecute")
            }
        })
    }


    class HomeFeed(val videos: List<Video>) {

    }

    class Video(val id: Int, val name: String) {

    }

}
