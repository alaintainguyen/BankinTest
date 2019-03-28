package com.tai.androidtai.modules.dashboard

import android.util.Log

import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.usecase.DashboardUseCase
import com.tai.androidtai.modules.core.BaseContract

import io.reactivex.annotations.NonNull
import io.reactivex.observers.ResourceObserver

class DashboardPresenter(private val mRouter: DashboardContract.Router, private val mDashboardUseCase: DashboardUseCase) : DashboardContract.Presenter {

    private var mView: DashboardContract.View? = null
    private var mResources: ArrayList<CategoryBean> = arrayListOf()

    companion object {
        private val TAG = DashboardPresenter::class.java.simpleName
    }

    override fun getInfo() {
        mDashboardUseCase.execute(GetInfoSubscriber())
    }

    override fun subscribe(view: BaseContract.View) {
        mView = view as DashboardContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun goToSubCategory(categoryId: Int, name: String?) {
        mRouter.goToSubCategory(categoryId, name, mResources, mView)
    }

    fun listAllCaterory(resources: ArrayList<CategoryBean>): ArrayList<CategoryBean> {
        val categoryList: ArrayList<CategoryBean> = arrayListOf()

        resources.let {
            for (item in resources) {
                if (item.getParent() == null) {
                    categoryList.add(item)
                }
            }
        }
        return categoryList
    }

    private inner class GetInfoSubscriber : ResourceObserver<ResourceBean>() {

        override fun onNext(@NonNull resources: ResourceBean) {
            mResources = resources.getResultList()
            val allCategories = listAllCaterory(resources.getResultList())
            mView?.displayInformation(allCategories)
        }

        override fun onError(@NonNull e: Throwable) {
            Log.e(TAG, e.message)
            mView?.displayError(e.message)
        }

        override fun onComplete() {
            // Nothing to do
        }
    }


}
