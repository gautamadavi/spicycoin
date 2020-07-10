package com.launch.spicycoin.domain.apicalls.news

import com.coinpaprika.apiclient.entity.NewsEntity
import com.launch.spicycoin.domain.apicalls.ApiFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

class NewsCalls : NewsCallsInterface {

    private var retrofit = ApiFactory().init().create(NewsCallsInterface::class.java)

    override fun getNews(): Observable<Response<List<NewsEntity>>> =
        retrofit.getNews()

}