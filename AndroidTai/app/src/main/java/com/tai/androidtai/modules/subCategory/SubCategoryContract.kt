package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseContract
import java.util.ArrayList

interface SubCategoryContract {

    interface View : BaseContract.View {
        fun displayAllSubCategories(subCategory: ArrayList<CategoryBean>)
    }

    interface Presenter : BaseContract.Presenter {
        fun parseSubCategory(categoryId: Int)
    }

}
