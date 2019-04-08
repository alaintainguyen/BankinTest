package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.usecase.SubCategoryUseCase
import com.tai.androidtai.modules.core.BaseContract
import io.reactivex.annotations.NonNull
import io.reactivex.observers.ResourceObserver

class SubCategoryPresenter(private val mSubDashboardUseCase: SubCategoryUseCase) : SubCategoryContract.Presenter {

    private var mView: SubCategoryContract.View? = null

    override fun subscribe(view: BaseContract.View) {
        mView = view as SubCategoryContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun parseSubCategory(categoryId: Int) {
        mSubDashboardUseCase.execute(GetSubCategorySubscriber(), categoryId)
    }

    inner class GetSubCategorySubscriber : ResourceObserver<List<CategoryBean>>() {

        override fun onNext(@NonNull subCategory: List<CategoryBean>) {
            mView?.displayAllSubCategories(subCategory)
        }

        override fun onError(@NonNull e: Throwable) {
            mView?.displayError()
        }

        override fun onComplete() {
            // Nothing to do
        }
    }

}
