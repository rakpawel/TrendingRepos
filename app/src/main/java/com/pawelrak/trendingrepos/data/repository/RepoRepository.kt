package com.pawelrak.trendingrepos.data.repository

import com.pawelrak.trendingrepos.api.GithubService
import com.pawelrak.trendingrepos.api.model.ReposResponse
import com.pawelrak.trendingrepos.data.model.GithubRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(private val service: GithubService) {
    fun searchRepos(topic: String, sort: String, order: String) : Single<ReposResponse> = service.searchRepos(topic, sort, order)
}