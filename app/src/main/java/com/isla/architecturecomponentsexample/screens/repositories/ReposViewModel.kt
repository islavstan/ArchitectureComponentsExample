package com.isla.architecturecomponentsexample.screens.repositories

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.isla.architecturecomponentsexample.models_db.Repo

class ReposViewModel(application: Application) : AndroidViewModel(application) {

    private val organizationLiveData = MutableLiveData<String>()

    val resultLiveData = ReposLiveData().apply {
        this.addSource(organizationLiveData) { it?.let { this.organization = it } }
    }

    val isLoadingLiveData = MediatorLiveData<Boolean>().apply {
        this.addSource(resultLiveData) { this.value = false }
    }

    val throwableLiveData = MediatorLiveData<Throwable>().apply {
        this.addSource(resultLiveData) { it?.second?.let { this.value = it } }
    }

    val reposLiveData = MediatorLiveData<List<Repo>>().apply {
        this.addSource(resultLiveData) { it?.first?.let { this.value = it } }
    }

    fun setOrganization(organization: String) {
        organizationLiveData.value = organization
        isLoadingLiveData.value = true
    }

}