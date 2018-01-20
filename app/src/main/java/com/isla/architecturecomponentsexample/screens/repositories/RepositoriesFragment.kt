package com.isla.architecturecomponentsexample.screens.repositories

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isla.architecturecomponentsexample.R
import com.isla.architecturecomponentsexample.base.BaseLifecycleFragment


class RepositoriesFragment : BaseLifecycleFragment<ReposViewModel>(), SwipeRefreshLayout.OnRefreshListener {

    override val viewModelClass = ReposViewModel::class.java

    companion object {
        fun newInstance() = RepositoriesFragment().apply {
            arguments = Bundle()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.repositories_fragment, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onRefresh() {

    }

}