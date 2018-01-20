package com.isla.architecturecomponentsexample.models_db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "repos")
data class Repo(
        @PrimaryKey var id: Long?,
        var name: String?,
        var full_name: String?,
        var description: String?,
        var organization: String?)