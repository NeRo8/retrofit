package com.example.nero.meteo.api.model

import com.google.gson.annotations.SerializedName


/**Тут все нормально. Створив клас, для роботи з таблицею сервера
 * тільки правда прийдеться певно створити, для цих всіх таблиць окремо директорію(пакет)
**/
data class Post(
    @SerializedName("userId") val userId: String,
    @SerializedName("id") val postId: String,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)