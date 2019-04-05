package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.cache.EcoMoneyDatabase
import com.tai.androidtai.domain.usecase.DashboardUseCase
import com.tai.androidtai.modules.core.BaseContract
import io.reactivex.annotations.NonNull
import io.reactivex.observers.ResourceObserver
import javax.inject.Inject

class DashboardPresenter(private val mRouter: DashboardContract.Router, private val mDashboardUseCase: DashboardUseCase) : DashboardContract.Presenter {

    private var mView: DashboardContract.View? = null
    private var mResources: List<CategoryBean> = arrayListOf()
    private var mDao: EcoMoneyDatabase.CachedResourcesDao? = null

    override fun subscribe(view: BaseContract.View) {
        mView = view as DashboardContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun getInfo() {
        mDashboardUseCase.execute(GetInfoSubscriber())
    }

    override fun goToSubCategory(categoryId: Int, name: String?) {
        mRouter.goToSubCategory(categoryId, name, mView)
    }

    fun listAllCaterory(resources: List<CategoryBean>): List<CategoryBean> {
        val categoryList: ArrayList<CategoryBean> = arrayListOf()

        resources.let {
            for (item in resources) {
                if (item.parent == null) {
                    categoryList.add(item)
                }
            }
        }
        return categoryList
    }

    inner class GetInfoSubscriber : ResourceObserver<List<CategoryBean>>() {

        override fun onNext(@NonNull resources: List<CategoryBean>) {
            mResources = resources
            val allCategories = listAllCaterory(resources)
            mView?.displayInformation(allCategories)
        }

        override fun onError(@NonNull e: Throwable) {
            mView?.displayError()
        }

        override fun onComplete() {
            // Nothing to do
        }
    }


}
