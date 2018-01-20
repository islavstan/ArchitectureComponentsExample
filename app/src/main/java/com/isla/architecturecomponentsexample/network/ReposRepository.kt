package com.isla.architecturecomponentsexample.network

import com.isla.architecturecomponentsexample.db.ReposLocalDataSource
import com.isla.architecturecomponentsexample.models_db.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object ReposRepository :ReposDataSource {


    override fun getRepositories(organization: String): Single<List<Repo>> =
            ReposLocalDataSource.getRepositories(organization)
                    .onErrorResumeNext {
                        ReposRemoteDataSource.getRepositories(organization).doOnSuccess {
                                    ReposLocalDataSource.saveRepositories(it)
                                }
                    } .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

}