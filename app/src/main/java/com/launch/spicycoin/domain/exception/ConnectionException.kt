package com.launch.spicycoin.domain.exception

import java.lang.Exception

class ConnectionException() : Exception() {

    constructor(cause: Throwable?) : this(){
    }

    override val message: String?
        get() = "There was a connection error"
}