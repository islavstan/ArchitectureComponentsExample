package com.isla.architecturecomponentsexample.network

import com.isla.architecturecomponentsexample.models_db.Repo
import io.reactivex.Single


interface ReposDataSource {

    fun getRepositories(organization: String): Single<List<Repo>>?

    fun saveRepositories(list: List<Repo>): Unit = Unit

}