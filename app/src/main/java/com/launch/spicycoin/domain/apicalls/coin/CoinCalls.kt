package com.launch.spicycoin.domain.apicalls.coin

import com.coinpaprika.apiclient.entity.CoinDetailsEntity
import com.coinpaprika.apiclient.entity.TweetEntity
import com.launch.spicycoin.domain.apicalls.ApiFactory
import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class CoinCalls(val apiFactory: ApiFactory) :
    CoinCallsInterface {

    private var retrofit = apiFactory.init().create(CoinCallsInterface::class.java)

    override suspend fun coins(): Response<List<CoinEntity>> =
        retrofit.coins()


    override suspend fun coin(coin_id: String): Single<Response<CoinDetailsEntity>> =
        retrofit.coin(coin_id)

    override fun coinTweets(coin_id: String): Response<List<TweetEntity>> =
        retrofit.coinTweets(coin_id)
}