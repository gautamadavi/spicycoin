package com.launch.spicycoin.domain.apicalls

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiFactory {

    fun init(): Retrofit =
        Retrofit.Builder().apply {
            baseUrl("https://api.coinpaprika.com/v1/")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            client(defaultClient().build())
        }.build()

}