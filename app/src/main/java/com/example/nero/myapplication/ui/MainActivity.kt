package com.example.nero.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.nero.meteo.api.TypicodeService
import com.example.nero.myapplication.R
import com.example.nero.myapplication.ui.adapters.MainAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var typicodeService: TypicodeService


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_post_list.layoutManager = LinearLayoutManager(this)
        rv_post_list.adapter = MainAdapter(
            /**
             * Коли передаю в адаптер ось це, то не запускається приложуха
             * а якщо закоментовую, то запускається
             * Подивись будьласка, чого воно так зі мною
             */
            typicodeService.getAllPosts().execute().body()
        )
    }
}