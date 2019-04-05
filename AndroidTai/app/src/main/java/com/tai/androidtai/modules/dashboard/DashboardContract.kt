package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.cache.EcoMoneyDatabase
import com.tai.androidtai.modules.core.BaseContract

interface DashboardContract {

    interface View : BaseContract.View {
        fun displayInformation(allCategories: List<CategoryBean>)
        fun displayError()
    }

    interface Presenter : BaseContract.Presenter {
        fun getInfo()
//        fun goToSubCategory(categoryId: Int, name: String?)
    }

    interface Router : BaseContract.Router {
//        fun goToSubCategory(categoryId: Int, name: String?, resources: ArrayList<CategoryBean>, view: View?)
    }

}
