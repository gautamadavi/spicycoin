package com.launch.spicycoin.application.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.launch.spicycoin.domain.apicalls.coin.CoinCalls
import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import com.launch.spicycoin.domain.dataclass.TweetEntity
import com.launch.spicycoin.domain.datalayer.CoinRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject


class HotListViewModel @ViewModelInject constructor(
    var coinCalls: CoinCalls,
    var coinRepository: CoinRepository
) : ViewModel() {

    fun downloadCoinList(): Observable<Response<List<CoinEntity>>> {
        return coinCalls.coins().doOnNext {
        }.subscribeOn(Schedulers.io())
    }

    fun getCachedCoinList(): Observable<List<CoinEntity>>{
       return coinRepository.getCachedCoinList()
            .filter { list: List<CoinEntity> -> list.isNotEmpty() }.subscribeOn(Schedulers.io())
    }

    fun handleCoinListData(){
        getCachedCoinList().map {

        }
        downloadCoinList().map {

        }
    }

    fun downloadCoinDetails(id: String): Observable<CoinDetailsEntity> {
        return coinCalls.coin(id).map {
            it.body()
        }
    }

    fun downloadTweet(id: String): Observable<List<TweetEntity>> {
        return coinCalls.coinTweets(id).map {
            it.body()
        }
    }

    fun downloadOHLCV(id: String): Observable<OHLCVEntity> {
        return coinCalls.coinOHLCV(id).map { it.body() }
    }


}