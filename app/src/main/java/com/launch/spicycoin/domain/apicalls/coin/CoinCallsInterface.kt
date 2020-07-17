package com.launch.spicycoin.domain.apicalls.coin

import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.TweetEntity
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import dagger.Binds
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinCallsInterface {


    @GET("coins")
    fun coins(): Observable<Response<List<CoinEntity>>>
    @GET("coins/{coin_id}/")
    fun coin(@Path("coin_id") coin_id:String) : Observable<Response<CoinDetailsEntity>>
    @GET("coins/{coin_id}/twitter/")
    fun coinTweets(@Path("coin_id") coin_id:String) : Observable<Response<List<TweetEntity>>>
    @GET("coins/{coin_id}/ohlcv/today/")
    fun coinOHLCV(@Path("coin_id") coin_id: String) : Observable<Response<OHLCVEntity>>

}