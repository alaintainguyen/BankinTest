package com.tai.androidtai.domain.usecase

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.repository.DashboardRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

@PerActivity
class DashboardUseCase

@Inject
internal constructor(postExecutionThread: Scheduler, private val mRepository: DashboardRepository) : UseCase<ResourceBean, Void>(postExecutionThread) {

    override fun buildObservable(params: Void?): Observable<ResourceBean>? {
        return mRepository.getInfo().flatMap { resource ->
            mRepository.setCache(resource.getResultList())
            Observable.just(resource)
        }
    }

}