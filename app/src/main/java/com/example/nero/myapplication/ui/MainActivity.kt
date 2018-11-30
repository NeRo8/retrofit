package com.example.nero.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.nero.myapplication.R
import com.example.nero.myapplication.api.TypicodeService
import com.example.nero.myapplication.api.models.Post
import com.example.nero.myapplication.ui.adapters.MainAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var typicodeService: TypicodeService


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_post_list.layoutManager = LinearLayoutManager(this)
        val call = typicodeService.getAllPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                rv_post_list.adapter = MainAdapter(
                    response.body()
                )
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                //Handle failure
            }
        })
    }
}

