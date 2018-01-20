package com.isla.architecturecomponentsexample.db

import com.isla.architecturecomponentsexample.models_db.Repo
import com.isla.architecturecomponentsexample.network.ReposDataSource
import io.reactivex.Single


object ReposLocalDataSource : ReposDataSource {

    val reposDao = DatabaseCreator.database.reposDao()

    override fun getRepositories(organization: String): Single<List<Repo>>
            = reposDao
            .loadAllRepos(organization)
            .firstOrError()
            .doOnSuccess { if (it.isEmpty()) throw Exception() }


    override fun saveRepositories(list: List<Repo>)
            =  reposDao.insertAll(list.toMutableList())

}