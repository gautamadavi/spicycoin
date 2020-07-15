package com.launch.spicycoin.domain.datalayer

import android.util.LruCache
import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class CoinRepository @Inject constructor() : CoinInterface {

    private var cacheSize:Int = 1 * 1024 * 1024 // 1MiB
    private var coinCache = LruCache<String, CoinEntity>(cacheSize)
    private var coinIDList = mutableListOf<String>()


    override fun storeCoin(x: CoinEntity): CoinEntity {
        coinCache.put(x.id, x)
        return saveCoinId(x)
    }

    override fun saveCoinId(x: CoinEntity): CoinEntity {
        if(!coinIDList.contains(x.id)){
            coinIDList.add(x.id)
        }
        return x
    }

    override fun getCoinIdList(): List<String> {
        return coinIDList
    }

    override fun getCoin(id:String): Observable<CoinEntity> {
        return Observable.just(coinCache.get(id))
    }

    override fun getCachedCoinList(): Observable<List<CoinEntity>> {
        if(coinIDList.isEmpty()){
            return Observable.just(emptyList())
        }else{
            var cachedCoinList = mutableListOf<CoinEntity>()
            for(coinId in coinIDList){
                getCoin(coinId).map {
                    cachedCoinList.add(it)
                }
            }
            return Observable.just(cachedCoinList)
        }
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