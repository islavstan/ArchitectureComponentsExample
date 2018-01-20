package com.isla.architecturecomponentsexample.screens.repositories

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isla.architecturecomponentsexample.R


class RepositoriesFragment: Fragment(){

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
}