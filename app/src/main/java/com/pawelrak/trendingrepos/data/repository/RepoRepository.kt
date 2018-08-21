package com.pawelrak.trendingrepos.data.repository

import com.pawelrak.trendingrepos.api.GithubService
import com.pawelrak.trendingrepos.data.model.GithubRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(val  service: GithubService) {
    fun getTrendingRepos() : Single<List<GithubRepository>> {
        var repos = arrayListOf<GithubRepository>(GithubRepository("repo 1"),
                GithubRepository("repo 2"))
        return Single.just(repos)
    }
}