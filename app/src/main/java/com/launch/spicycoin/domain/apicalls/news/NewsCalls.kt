package com.launch.spicycoin.domain.apicalls.news

import com.coinpaprika.apiclient.entity.NewsEntity
import com.launch.spicycoin.application.CoinModule
import com.launch.spicycoin.domain.apicalls.safeCall
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import javax.inject.Inject

class NewsCalls @Inject constructor( @CoinModule.NewsRetrofitClient private var retrofit: NewsCallsInterface): NewsCallsInterface {


    override fun getNews(): Observable<Response<List<NewsEntity>>> =
        safeCall { retrofit.getNews()}

}