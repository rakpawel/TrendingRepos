package com.pawelrak.trendingrepos.ui.repository.list


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.pawelrak.trendingrepos.R
import com.pawelrak.trendingrepos.databinding.FragmentRepositoryListBinding
import com.pawelrak.trendingrepos.di.Injectable
import com.pawelrak.trendingrepos.extension.observe
import com.pawelrak.trendingrepos.util.autoCleared
import javax.inject.Inject

class RepositoryListFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RepositoryListViewModel

    var binding by autoCleared<FragmentRepositoryListBinding>()

    private var adapter by autoCleared<RepositoriesAdapter>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_repository_list,
                container,
                false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoryListViewModel::class.java)
        binding.viewmodel = viewModel
        val adapter = RepositoriesAdapter { repo ->
            navController().navigate(
                    RepositoryListFragmentDirections.showRepoDetails(repo)
            )
        }
        this.adapter = adapter
        binding.repositoryList.adapter = adapter
        setUpViewModelStateObservers()
    }

    private fun setUpViewModelStateObservers() {
        observe(viewModel.getState()) { onStateChanged(it) }
    }

    private fun onStateChanged(state: RepositoryListViewModel.State) = when (state) {
        is RepositoryListViewModel.State.ReposLoaded -> adapter.submitList(state.data)
        RepositoryListViewModel.State.ShowLoading -> Log.d("loading event", "repos loading")
        RepositoryListViewModel.State.ShowContent -> Log.d("loading event", "repos show")
        RepositoryListViewModel.State.ShowError -> Log.d("loading event", "repos loading error")
        RepositoryListViewModel.State.EmptyData -> Log.d("loading event", "repos empty data")
    }

    fun navController() = findNavController()
}
