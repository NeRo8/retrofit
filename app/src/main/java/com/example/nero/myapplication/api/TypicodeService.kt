package com.example.nero.meteo.api

import com.example.nero.meteo.api.model.Comment
import com.example.nero.meteo.api.model.Post
import com.example.nero.meteo.api.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/** TypicodeService інтерфейс, для виконання запитів до сервреру.
 * Для кожного сайту свій API повинен бути.
 * Тому реалізація усіх запитів, до різних таблиць повинна бути у цьому файлі
 */

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