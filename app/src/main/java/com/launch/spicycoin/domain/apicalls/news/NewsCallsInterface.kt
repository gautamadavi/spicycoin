package com.launch.spicycoin.domain.apicalls.news

import com.coinpaprika.apiclient.entity.NewsEntity
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET


interface NewsCallsInterface {

    @GET("news/latest/")
    fun getNews() : Observable<Response<List<NewsEntity>>>
}