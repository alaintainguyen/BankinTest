package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.modules.core.BaseContract

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

    override fun parseSubCategory(categoryId: Int) {
        // Todo SubCategoryUseCase
        // mView?.displayAllSubCategories(subCategory)

    }

}
