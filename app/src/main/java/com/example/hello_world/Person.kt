package com.example.hello_world

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val phone: String,
    val age: Int,
    val hobby: String,
    val sex: String
): Parcelable