package com.pawelrak.trendingrepos.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
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
    abstract fun bindMainScreenViewModel(repositoryListViewModel: RepositoryListViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ReposViewModelFactory): ViewModelProvider.Factory
}