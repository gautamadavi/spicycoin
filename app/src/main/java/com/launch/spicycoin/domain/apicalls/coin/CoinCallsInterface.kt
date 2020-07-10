package com.launch.spicycoin.domain.apicalls.coin

import com.coinpaprika.apiclient.entity.CoinDetailsEntity
import com.coinpaprika.apiclient.entity.TweetEntity
import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface CoinCallsInterface {


    @GET ("coins")
    suspend fun coins() : Response<List<CoinEntity>>
    @GET("coins/{coin_id}/")
    suspend fun coin(@Path("coin_id") coin_id:String) : Single<Response<CoinDetailsEntity>>
    @GET("coins/{coin_id}/twitter/")
    fun coinTweets(@Path("coin_id") coin_id:String) : Response<List<TweetEntity>>

}