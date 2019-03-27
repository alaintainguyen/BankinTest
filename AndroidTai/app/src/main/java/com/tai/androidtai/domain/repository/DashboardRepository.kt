package com.tai.androidtai.domain.repository

import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.bean.CategoryBean
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

class DashboardRepository

@Inject
constructor(retrofit: Retrofit) {

    private val mService: DashboardService

    init {
        mService = retrofit.create(DashboardService::class.java)
    }

    fun getInfo(): Observable<ResourceBean> {
        return mService.getInfo()
    }

    private interface DashboardService {

        @GET("bankin-engineering/challenge-android/master/categories.json")
        fun getInfo(): Observable<ResourceBean>

    }
}
