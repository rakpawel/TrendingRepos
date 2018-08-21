package com.pawelrak.trendingrepos.ui.repository.details

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pawelrak.trendingrepos.R
import com.pawelrak.trendingrepos.databinding.FragmentRepositoryDetailsBinding
import com.pawelrak.trendingrepos.di.Injectable
import com.pawelrak.trendingrepos.util.autoCleared
import javax.inject.Inject

class RepositoryDetailsFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RepositoryDetailsViewModel

    var binding by autoCleared<FragmentRepositoryDetailsBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val dataBinding = DataBindingUtil.inflate<FragmentRepositoryDetailsBinding>(
                inflater,
                R.layout.fragment_repository_details,
                container,
                false
        )

        binding = dataBinding
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoryDetailsViewModel::class.java)
        binding.viewmodel = viewModel

        val params = RepositoryDetailsFragmentArgs.fromBundle(arguments)
        viewModel.repository.set(params.repository)
    }

}
