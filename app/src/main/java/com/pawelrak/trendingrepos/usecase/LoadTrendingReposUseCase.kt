package com.pawelrak.trendingrepos.usecase

import com.pawelrak.trendingrepos.api.model.ReposResponse
import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.pawelrak.trendingrepos.data.repository.RepoRepository
import com.pawelrak.trendingrepos.usecase.common.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadTrendingReposUseCase
@Inject constructor(private val reposRepository: RepoRepository) :
        BaseUseCase<Result<List<GithubRepository>>>() {

    fun execute() {
        reposRepository.searchRepos("topic:android", "stars", "desc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::success, ::error)
                .track()
    }

    private fun success(repos: ReposResponse) {
        liveData.value = Result.Success(repos.items)
    }

    private fun error(throwable: Throwable) {
        liveData.value = Result.Failure(throwable)
    }
}