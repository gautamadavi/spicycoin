package com.launch.spicycoin.application

import com.launch.spicycoin.domain.apicalls.coin.CoinCalls
import com.launch.spicycoin.domain.apicalls.coin.CoinCallsInterface
import com.launch.spicycoin.domain.apicalls.defaultClient
import com.launch.spicycoin.domain.apicalls.news.NewsCallsInterface
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory.create
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

@Module
@InstallIn(ActivityRetainedComponent::class)
class CoinModule {

    @CoinRetrofitClient
    @Provides
    fun provideCoinCallsInterface() : CoinCallsInterface{
        return Retrofit.Builder().apply {
            baseUrl("https://api.coinpaprika.com/v1/")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(create())
            client(defaultClient().build())

        }.build().create(CoinCallsInterface::class.java)}

    @NewsRetrofitClient
    @Provides
    fun provideNewsCallsInterface() : NewsCallsInterface{
        return Retrofit.Builder().apply {
            baseUrl("https://api.coinpaprika.com/v1/")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(create())
            client(defaultClient().build())

        }.build().create(NewsCallsInterface::class.java)}

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CoinRetrofitClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NewsRetrofitClient

}