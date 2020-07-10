package com.launch.spicycoin.domain.apicalls

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.util.concurrent.TimeUnit

fun defaultClient(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
        .readTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .connectTimeout(15, TimeUnit.SECONDS)
        .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
}