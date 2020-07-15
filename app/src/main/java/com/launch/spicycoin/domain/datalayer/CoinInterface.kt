package com.launch.spicycoin.domain.datalayer

import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CoinInterface {

    fun storeCoin(x: CoinEntity): CoinEntity
    fun getCoin(id:String): Observable<CoinEntity>
    fun storeCoinList(x:List<CoinEntity>): List<CoinEntity>
    fun deleteCoin(id:String):Boolean
    fun saveCoinId(x:CoinEntity): CoinEntity
    fun getCoinIdList(): List<String>
    fun getCachedCoinList(): Observable<List<CoinEntity>>

}