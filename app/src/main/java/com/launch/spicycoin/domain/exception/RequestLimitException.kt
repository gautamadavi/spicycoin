package com.launch.spicycoin.domain.exception

import java.lang.Exception

class RequestLimitException : Exception() {

    override val message: String?
        get() = "Too many server requests"
}