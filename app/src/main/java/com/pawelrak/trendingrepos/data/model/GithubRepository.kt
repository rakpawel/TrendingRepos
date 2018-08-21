package com.pawelrak.trendingrepos.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepository(
        @Json(name = "name") val name: String,
        @Json(name = "full_name") val fullName: String,
        @Json(name = "language") val language: String,
        @Json(name = "description") val description: String,
        @Json(name = "stargazers_count") val stargazers: Int,
        @Json(name = "watchers_count") val watchers: Int) : Parcelable