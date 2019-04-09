package com.tai.androidtai.domain.usecase

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.repository.DashboardRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

@PerActivity
class SubCategoryUseCase

@Inject
internal constructor(postExecutionThread: Scheduler, private val mRepository: DashboardRepository) : UseCase<List<CategoryBean>, Int>(postExecutionThread) {

    override fun buildObservable(id: Int): Observable<List<CategoryBean>>? {
        return mRepository.getSubCategory(id)
    }

}