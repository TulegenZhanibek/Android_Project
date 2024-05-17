package com.example.lab3.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()

            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiODJjMTcyZTdiZjY2NjA1MTY4ODFjNmExZWQ2MTZkZCIsInN1YiI6IjVmOTFiMTNhNTVjMWY0MDAzOTI3OTlhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3958aU9e_thJZ7JwmT-bFyILptSQnJq51dEzJRAXzY8")
                .build()

            chain.proceed(newRequest)
        }
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://console.firebase.google.com/project/lab3-6ca32/database/lab3-6ca32-default-rtdb/data/~2F?fb_utm_source=studio")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}