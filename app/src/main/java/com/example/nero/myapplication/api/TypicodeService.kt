package com.example.nero.myapplication.api

import com.example.nero.myapplication.api.models.Comment
import com.example.nero.myapplication.api.models.Post
import com.example.nero.meteo.api.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TypicodeService {
    @GET("posts/")
    fun getAllPosts(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getPostById(@Path("postId") postId: String): Call<Post>

    @GET("users/")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{userId}")
    fun getUserById(@Path("userId") userId: String): Call<User>

    @GET("comments/")
    fun getAllComments(@Query("postId") postId:String): Call<List<Comment>>


}