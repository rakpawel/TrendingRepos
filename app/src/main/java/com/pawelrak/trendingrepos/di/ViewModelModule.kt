package com.pawelrak.trendingrepos.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pawelrak.trendingrepos.ui.repository.details.RepositoryDetailsViewModel
import com.pawelrak.trendingrepos.ui.repository.list.RepositoryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepositoryListViewModel::class)
    abstract fun bindRepositoryListViewModel(repositoryListViewModel: RepositoryListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoryDetailsViewModel::class)
    abstract fun bindRepositoryDetailsViewModel(repositoryDetailsViewModel: RepositoryDetailsViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ReposViewModelFactory): ViewModelProvider.Factory
}