package com.pawelrak.trendingrepos.ui.repository.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pawelrak.trendingrepos.R
import com.pawelrak.trendingrepos.di.Injectable

class RepositoryListFragment : Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repository_list, container, false)
    }


}
