package com.launch.spicycoin.domain.datalayer

import android.util.LruCache
import com.launch.spicycoin.domain.apicalls.ApiFactory
import com.launch.spicycoin.domain.apicalls.coin.CoinCalls
import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Single

class CoinRepository(var api:CoinCalls) : CoinInterface {

    private var cacheSize:Int = 1 * 1024 * 1024 // 1MiB
    private var coinCache = LruCache<String, CoinEntity>(cacheSize)


    override fun storeCoin(x: CoinEntity): CoinEntity {
        coinCache.put(x.id, x)
        return x
    }

    override fun getCoin(id:String): Single<CoinEntity> {
        return Single.just(coinCache.get(id))
    }

    override fun storeCoinList(x: List<CoinEntity>): List<CoinEntity> {
        for(coin in x){
            storeCoin(coin)
        }
        return x
    }

    override fun deleteCoin(id: String): Boolean {
        coinCache.remove(id)
        return true
    }
}