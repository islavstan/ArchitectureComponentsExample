package com.isla.architecturecomponentsexample.screens.repositories

import android.arch.lifecycle.MediatorLiveData
import com.isla.architecturecomponentsexample.models_db.Repo
import com.isla.architecturecomponentsexample.network.ReposRepository
import io.reactivex.disposables.Disposable

class ReposLiveData : MediatorLiveData<Pair<List<Repo>?, Throwable?>>() {

    private var disposable: Disposable? = null

    var organization: String? = null
        set(value) {
            value?.let {
                disposable = ReposRepository
                        .getRepositories(it)
                        .subscribe { data, error -> this@ReposLiveData.value = Pair(data, error)}

            }
        }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}