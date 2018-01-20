package com.isla.architecturecomponentsexample.base

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

@Suppress("LeakingThis")
abstract class BaseLifecycleFragment<T : AndroidViewModel> : Fragment() {

    abstract val viewModelClass: Class<T>

    protected val viewModel: T by lazy { ViewModelProviders.of(this).get(viewModelClass) }

    private val registry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = registry
}