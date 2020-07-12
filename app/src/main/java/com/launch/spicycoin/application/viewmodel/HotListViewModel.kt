package com.launch.spicycoin.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.launch.spicycoin.domain.apicalls.coin.CoinCalls
import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import com.launch.spicycoin.domain.dataclass.TweetEntity
import io.reactivex.rxjava3.core.Observable
import java.sql.Time
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HotListViewModel @Inject constructor(var coinCalls: CoinCalls ) : ViewModel() {

    private var coinList = ArrayList<CoinEntity>()

    fun getCoinList(): List<CoinEntity> {
        return coinList
    }

    fun downloadCoinList(): Observable<List<CoinEntity>>{
        return coinCalls.coins().map {
            it.body()
        }
    }

    fun downloadCoinDetails(id:String): Observable<CoinDetailsEntity>{
        return coinCalls.coin(id).map { it.body() }
    }

    fun downloadTweet(id:String): Observable<List<TweetEntity>>{
        return coinCalls.coinTweets(id).map {
            it.body()
        }
    }

    fun downloadOHLCV(id:String): Observable<OHLCVEntity>{
        return coinCalls.coinOHLCV(id).map { it.body() }
    }


}