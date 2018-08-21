package com.pawelrak.trendingrepos.api

import com.pawelrak.trendingrepos.api.model.ReposResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun searchRepos(@Query("q") q: String, @Query("sort") sort: String, @Query("order") order: String): Single<ReposResponse>
}