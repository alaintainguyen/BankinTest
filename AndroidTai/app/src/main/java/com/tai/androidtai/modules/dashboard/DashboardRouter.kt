package com.tai.androidtai.modules.dashboard

import android.content.Intent
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseRouter
import com.tai.androidtai.modules.subCategory.SubCategoryActivity

class DashboardRouter : BaseRouter(), DashboardContract.Router {

    override fun goToSubCategory(categoryId: Int, name: String?, resources: ArrayList<CategoryBean>, view: DashboardContract.View?) {
        val intent = Intent(getActivity(view!!), SubCategoryActivity::class.java)
        intent.putExtra(SubCategoryActivity.RESOURCES, resources)
        intent.putExtra(SubCategoryActivity.CATEGORY_ID, categoryId)
        intent.putExtra(SubCategoryActivity.NAME, name)
        getActivity(view)?.startActivity(intent)
    }
}
