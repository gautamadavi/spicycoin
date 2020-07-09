package com.launch.spicycoin.domain.dataclass

import com.google.gson.annotations.SerializedName

enum class CoinType {
    @SerializedName("coin") Coin,
    @SerializedName("token") Token
}