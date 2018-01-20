package com.isla.architecturecomponentsexample.network


object ReposRemoteDataSource : ReposDataSource {
    private var api: Api = RestClient.getInstance().create(Api::class.java)

    override fun getRepositories(organization: String) = api.getRepositories(organization)
}