package com.launch.spicycoin

import com.launch.spicycoin.domain.dataclass.TweetEntity
import com.launch.spicycoin.domain.apicalls.coin.CoinCalls
import com.launch.spicycoin.domain.apicalls.coin.CoinCallsInterface
import com.launch.spicycoin.domain.dataclass.CoinDetailsEntity
import com.launch.spicycoin.domain.dataclass.CoinEntity
import com.launch.spicycoin.domain.dataclass.OHLCVEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class CoinCallsTest {

    @Mock
    private lateinit var mockApi: CoinCallsInterface
    @Mock
    private lateinit var mockCoin: CoinEntity
    @Mock
    private lateinit var mockDetailsCoin: CoinDetailsEntity
    @Mock
    private lateinit var mockTweetEntity: TweetEntity
    @Mock
    private lateinit var mockOHLCVEntity: OHLCVEntity

    @Test
    fun coinsListSuccess(){

        val coinsList = listOf(mockCoin)
        val response = Response.success(coinsList)
        val client = CoinCalls(mockApi)
        val testObserver = TestObserver<Response<List<CoinEntity>>>()

        `when`(mockApi.coins()).thenReturn(Observable.just(response))

        client.coins().subscribe(testObserver)
        testObserver
            .assertComplete()
            .assertValue(response)
    }

    @Test
    fun coinSuccess() {
        val coin = mockDetailsCoin
        val response = Response.success(coin)
        val client = CoinCalls(mockApi)
        val testObserver = TestObserver<Response<CoinDetailsEntity>>()

        `when`(mockApi.coin("btc-bitcoin")).thenReturn(Observable.just(response))

        client.coin("btc-bitcoin").subscribe(testObserver)
        testObserver
            .assertComplete()
            .assertValue(response)
    }

    @Test
    fun tweetListSuccess(){
        val tweetList = listOf(mockTweetEntity)
        val tweetListResponse = Response.success(tweetList)

        val testObserver = TestObserver<Response<List<TweetEntity>>>()

        `when`(mockApi.coinTweets("btc-bitcoin")).thenReturn(Observable.just(tweetListResponse))
        val client = CoinCalls(mockApi)
        client.coinTweets("btc-bitcoin").subscribe(testObserver)

        testObserver
            .assertComplete()
            .assertResult(tweetListResponse)
    }

    @Test
    fun ohlcvSuccess(){
        val ohlcvEntity = mockOHLCVEntity
        val response = Response.success(ohlcvEntity)
        val client = CoinCalls(mockApi)
        val testObserver = TestObserver<Response<OHLCVEntity>>()
        `when`(mockApi.coinOHLCV("btc-bitcoin")).thenReturn(Observable.just(response))
        client.coinOHLCV("btc-bitcoin").subscribe(testObserver)

        testObserver.awaitDone(10, TimeUnit.SECONDS)
            .assertComplete()
            .assertValue(response)
    }

}
