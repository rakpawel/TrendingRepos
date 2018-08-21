package com.pawelrak.trendingrepos.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepository (val name: String) : Parcelable