package com.launch.spicycoin.domain.datalayer

import com.launch.spicycoin.domain.dataclass.CoinEntity
import io.reactivex.rxjava3.core.Single

interface CoinInterface {

    fun storeCoin(x: CoinEntity): CoinEntity
    fun getCoin(id:String): Single<CoinEntity>
    fun storeCoinList(x:List<CoinEntity>): List<CoinEntity>
    fun deleteCoin(id:String):Boolean

}