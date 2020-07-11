package com.launch.spicycoin.domain.dataclass

import com.google.gson.annotations.SerializedName

open class OHLCVEntity (@SerializedName("time_open") val time_open: String,
                   @SerializedName("time_close") val time_close: String,
                   @SerializedName("open") val open: Int,
                   @SerializedName("high") val high: Int,
                   @SerializedName("low") val low:Int,
                   @SerializedName("close") val close: Int,
                   @SerializedName("volume") val volume: Int,
                   @SerializedName("market_cap") val market_cap: Int
                   )

