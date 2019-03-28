package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseContract

interface DashboardContract {

    interface View : BaseContract.View {
        fun displayInformation(allCategories: ArrayList<CategoryBean>)
        fun displayError(message: String?)
    }

    interface Presenter : BaseContract.Presenter {
        fun getInfo()
        fun goToSubCategory(categoryId: Int, name: String?)
    }

    interface Router : BaseContract.Router {
        fun goToSubCategory(categoryId: Int, name: String?, resources: ArrayList<CategoryBean>, view: View?)
    }

}
