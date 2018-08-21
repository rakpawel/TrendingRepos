package com.pawelrak.trendingrepos.api.model

import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.squareup.moshi.Json

data class ReposResponse(
        @Json(name = "total_count") val totalCount: Int,
        @Json(name = "items") val items: List<GithubRepository>
)
