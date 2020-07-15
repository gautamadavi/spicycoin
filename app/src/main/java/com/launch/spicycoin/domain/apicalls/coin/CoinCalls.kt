package com.launch.spicycoin.domain.apicalls.coin

import com.launch.spicycoin.application.CoinModule
import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.TweetEntity

import com.launch.spicycoin.domain.apicalls.safeCall
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import javax.inject.Inject

class CoinCalls @Inject constructor( @CoinModule.CoinRetrofitClient private var retrofit: CoinCallsInterface) :
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