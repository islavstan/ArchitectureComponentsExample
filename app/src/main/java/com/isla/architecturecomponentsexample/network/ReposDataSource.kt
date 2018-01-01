package com.isla.architecturecomponentsexample.network

import com.isla.architecturecomponentsexample.entities.Repo
import rx.Single

interface ReposDataSource {

    fun getRepositories(organization: String): Single<List<Repo>>
    fun saveRepositories(list: List<Repo>): Unit = Unit

}