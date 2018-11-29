package com.example.nero.myapplication.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nero.meteo.api.model.Post
import com.example.nero.myapplication.R

class MainAdapter(private val myPostList: List<Post>?) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_list_view, parent, false))
    }

    override fun getItemCount() = myPostList!!.size

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.postTitle.text = myPostList?.get(position)?.title
        holder.postBody.text = myPostList?.get(position)?.body
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle by lazy { view.findViewById<TextView>(R.id.post_title) }
        val postBody by lazy { view.findViewById<TextView>(R.id.post_body) }
    }
}

