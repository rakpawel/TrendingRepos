package com.pawelrak.trendingrepos.usecase

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseUseCase<T> (private val compositeDisposable: CompositeDisposable = CompositeDisposable(),
                               protected val liveData: MutableLiveData<T> = MutableLiveData()) {
    protected fun Disposable.track() {
        compositeDisposable.add(this)
    }

    fun getLiveData(): LiveData<T> = liveData

    fun cleanUp() {
        compositeDisposable.clear()
    }
}