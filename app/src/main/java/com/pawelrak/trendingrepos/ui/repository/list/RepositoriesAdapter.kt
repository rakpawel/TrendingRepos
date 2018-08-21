package com.pawelrak.trendingrepos.ui.repository.list

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pawelrak.trendingrepos.R
import com.pawelrak.trendingrepos.data.model.GithubRepository
import com.pawelrak.trendingrepos.databinding.RepositoryItemBinding
import com.pawelrak.trendingrepos.ui.common.DataBoundListAdapter

class RepositoriesAdapter  (
        private val callback: ((GithubRepository) -> Unit)?
) : DataBoundListAdapter<GithubRepository, RepositoryItemBinding>(
        diffCallback = object : DiffUtil.ItemCallback<GithubRepository>() {
            override fun areItemsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
                return oldItem.name == newItem.name
                        && oldItem.name == newItem.name
            }
        }
) {
    override fun createBinding(parent: ViewGroup): RepositoryItemBinding {
        val binding = DataBindingUtil
                .inflate<RepositoryItemBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.repository_item,
                        parent,
                        false
                )

        binding.root.setOnClickListener {
            binding.repo?.let {
                callback?.invoke(it)
            }
        }

        return binding
    }

    override fun bind(binding: RepositoryItemBinding, item: GithubRepository) {
        binding.repo = item
    }

}