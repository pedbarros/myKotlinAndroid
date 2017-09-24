package com.mykotlin.mykotlin.domain

import java.io.Serializable

/**
 * Created by pedro on 24/09/2017.
 */

data class User(var username: String, var password: Int): Serializable{
    override fun toString(): String {
        return "$username - $password"
    }
}