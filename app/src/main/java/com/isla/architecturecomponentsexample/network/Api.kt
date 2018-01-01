package com.isla.architecturecomponentsexample.network

import com.isla.architecturecomponentsexample.entities.Repo
import io.reactivex.Single
import retrofit2.http.GET

interface Api {
    @GET("orgs/{organization}/repos")
    fun getRepositories(organization: String): Single<List<Repo>>
}