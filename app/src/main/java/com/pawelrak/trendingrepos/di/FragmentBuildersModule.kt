package com.pawelrak.trendingrepos.di

import com.pawelrak.trendingrepos.ui.repository.details.RepositoryDetailsFragment
import com.pawelrak.trendingrepos.ui.repository.list.RepositoryListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepositoryListFragment(): RepositoryListFragment

    @ContributesAndroidInjector
    abstract fun contributeRepositoryDetailsFragment(): RepositoryDetailsFragment
}
