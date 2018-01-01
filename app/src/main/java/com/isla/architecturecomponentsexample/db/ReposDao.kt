package com.isla.architecturecomponentsexample.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.isla.architecturecomponentsexample.entities.Repo
import io.reactivex.Flowable

@Dao
interface ReposDao {

    @Query("SELECT * FROM repos")
    fun loadAllRepos(): Flowable<List<Repo>>

    @Query("SELECT * FROM repos WHERE organization = :organization")
    fun loadAllRepos(organization: String?): Flowable<List<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: MutableList<Repo>): Unit

}