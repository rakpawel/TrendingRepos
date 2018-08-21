package com.pawelrak.trendingrepos.ui.repository.details

import android.databinding.ObservableField
import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.pawelrak.trendingrepos.util.ObservableViewModel
import javax.inject.Inject

class RepositoryDetailsViewModel @Inject constructor() : ObservableViewModel() {
    val repository = ObservableField<GithubRepository>()
}