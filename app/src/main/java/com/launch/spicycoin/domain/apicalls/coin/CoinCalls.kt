package com.launch.spicycoin.domain.apicalls.coin

import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.TweetEntity
import com.launch.spicycoin.domain.apicalls.ApiFactory

import com.launch.spicycoin.domain.apicalls.safeCall
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

class CoinCalls(private var retrofit: CoinCallsInterface = ApiFactory().init().create(CoinCallsInterface::class.java)) :
    CoinCallsInterface {


    override fun coins(): Observable<Response<List<CoinEntity>>> =
        safeCall { retrofit.coins() }

    override fun coin(coin_id: String): Observable<Response<CoinDetailsEntity>> =
        safeCall { retrofit.coin(coin_id) }

    override fun coinTweets(coin_id: String): Observable<Response<List<TweetEntity>>> =
        safeCall {  retrofit.coinTweets(coin_id) }

    override fun coinOHLCV(coin_id: String): Observable<Response<OHLCVEntity>> =
       safeCall { retrofit.coinOHLCV(coin_id) }

}