package com.pawelrak.trendingrepos.usecase

import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.pawelrak.trendingrepos.data.repository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadTrendingReposUseCase
@Inject constructor(private val reposRepository: RepoRepository) :
        BaseUseCase<Result<List<GithubRepository>>>() {

    fun execute() {
        reposRepository.getTrendingRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::success, ::error)
                .track()
    }

    private fun success(repos: List<GithubRepository>) {
        liveData.value = Result.Success(repos)
    }

    private fun error(throwable: Throwable) {
        liveData.value = Result.Failure(throwable)
    }
}