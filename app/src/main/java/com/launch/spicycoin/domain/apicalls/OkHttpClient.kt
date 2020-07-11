package com.launch.spicycoin.domain.apicalls

import com.launch.spicycoin.domain.exception.ConnectionException
import com.launch.spicycoin.domain.exception.RequestLimitException
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.disposables.Disposable
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Response
import java.lang.Exception
import java.util.concurrent.TimeUnit

fun defaultClient(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
        .readTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .connectTimeout(15, TimeUnit.SECONDS)
        .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
}

internal fun <T : Any> safeCall(method: () -> Observable<Response<T>>): Observable<Response<T>> {
    return Observable.create {emitter ->
        try {
            method()
                .doOnNext{
                    if(emitter.isDisposed){return@doOnNext}
                    if (it.isSuccessful) {
                        emitter.onNext(it)
                    }
                    else {
                        when (it.code()) {
                            429  -> emitter.onError(RequestLimitException())
                            else -> emitter.onError(ConnectionException())
                        }
                    }
                }
                .onErrorResumeNext {Observable.error(ConnectionException(it.cause)) }
                .doOnComplete { emitter.onComplete() }
                .doOnError { emitter.onError(it) }
                .subscribe({}, {})

        } catch (e: Exception) {
            emitter.onError(ConnectionException(e.cause))
        }
    }
}
