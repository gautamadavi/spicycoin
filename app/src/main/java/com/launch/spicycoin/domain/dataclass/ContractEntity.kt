package com.launch.spicycoin.domain.dataclass

import com.google.gson.annotations.SerializedName

data class ContractEntity(
    @SerializedName("contract") val contract: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("type") val type: String
)