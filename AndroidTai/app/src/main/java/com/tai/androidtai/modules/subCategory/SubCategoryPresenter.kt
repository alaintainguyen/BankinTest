package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseContract
import java.util.ArrayList

class SubCategoryPresenter : SubCategoryContract.Presenter {

    private var mView: SubCategoryContract.View? = null

    override fun subscribe(view: BaseContract.View) {
        mView = view as SubCategoryContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun parseSubCategory(resources: ArrayList<CategoryBean>?, categoryId: Int) {
        val subCategory: ArrayList<CategoryBean> = arrayListOf()
        resources?.let {
            for (resource in resources) {
                if (resource.getParent()?.getId() == categoryId) {
                    subCategory.add(resource)
                }
            }
        }
        mView?.displayAllSubCategories(subCategory)
    }

}
