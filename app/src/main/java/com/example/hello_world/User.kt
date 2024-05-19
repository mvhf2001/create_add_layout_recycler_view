package com.example.hello_world

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val email: String,
    var phone: String? = null
): Parcelable