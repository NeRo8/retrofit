package com.example.nero.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.nero.meteo.api.TypicodeService
import com.example.nero.meteo.api.model.Post
import com.example.nero.myapplication.R
import com.example.nero.myapplication.ui.adapters.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_post_list.layoutManager = LinearLayoutManager(this)

        val retorfit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val typicodeService = retorfit.create(TypicodeService::class.java)

        typicodeService.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val adapter = MainAdapter(response.body()!!)
                rv_post_list.adapter = adapter
            }
        })
    }
}