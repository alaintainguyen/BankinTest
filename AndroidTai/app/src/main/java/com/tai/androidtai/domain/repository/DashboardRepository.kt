package com.tai.androidtai.domain.repository

import android.content.Context
import androidx.room.Room
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.cache.EcoMoneyDatabase
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class DashboardRepository

@Inject
constructor(retrofit: Retrofit) {

    private var mService: DashboardService
    private var mDao: EcoMoneyDatabase.CachedResourcesDao? = null

    init {
        mService = retrofit.create(DashboardService::class.java)
    }

    @Inject
    fun DashboardRepository(context: Context) {
        val db = Room.databaseBuilder(context, EcoMoneyDatabase::class.java, "database-name").build()
        mDao = db.cachedResourcesDao()
    }

    fun getInfo(): Observable<ResourceBean> {
        return mService.getInfo()
    }

    fun setCache(resource: List<CategoryBean>) {
        mDao?.deleteAll()
        mDao?.insertAll(resource)
    }

    fun getAll(): List<CategoryBean>? {
        return mDao?.getAll()
    }

    private interface DashboardService {

        @GET("bankin-engineering/challenge-android/master/categories.json")
        fun getInfo(): Observable<ResourceBean>

    }
}
