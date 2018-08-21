package com.pawelrak.trendingrepos.ui.repository.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.pawelrak.trendingrepos.usecase.LoadTrendingReposUseCase
import com.pawelrak.trendingrepos.usecase.Result
import com.pawelrak.trendingrepos.util.ObservableViewModel
import javax.inject.Inject

class RepositoryListViewModel @Inject constructor(private val useCase: LoadTrendingReposUseCase) :  ObservableViewModel()  {

    val state: MediatorLiveData<State> = MediatorLiveData()

    init {
        state.addSource(useCase.getLiveData(), ::onLoadRepos)
    }

    override fun onCleared() {
        useCase.cleanUp()
    }

    fun fetchRepos() {
        state.value = State.ShowLoading
        useCase.execute()
    }

    private fun onLoadRepos(result: Result<List<GithubRepository>>?) {
        when (result) {
            is Result.Success -> {
                state.value = State.ReposLoaded(result.data)
            }
            is Result.Failure -> state.value = State.ShowError
        }
    }

    sealed class State {
        data class ReposLoaded(val data: List<GithubRepository>) : State()
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    fun getState(): LiveData<State> = state
}