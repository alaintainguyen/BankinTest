package com.tai.androidtai.modules.subCategory

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_sub_categories.*
import javax.inject.Inject

class SubCategoryActivity : BaseActivity(), SubCategoryContract.View {

    companion object {
        const val CATEGORY_ID: String = "id"
        const val NAME: String = "name"
        const val NUMBER_OF_COLUMN: Int = 2
    }

    @Inject
    lateinit var mPresenter: SubCategoryContract.Presenter

    private lateinit var mSubCategoryListAdapter: SubCategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_categories)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.setNavigationOnClickListener { finish() }

        mSubCategoryListAdapter = SubCategoryListAdapter()

        sub_category_rv.setHasFixedSize(true)
        sub_category_rv.layoutManager = GridLayoutManager(this, NUMBER_OF_COLUMN)
        sub_category_rv.adapter = mSubCategoryListAdapter

        val categoryId = intent.getIntExtra(CATEGORY_ID, -1)
        val categoryName = intent.getStringExtra(NAME)

        sub_category_name.text = categoryName

        mPresenter.parseSubCategory(categoryId)
    }

    override fun displayAllSubCategories(subCategory: ArrayList<CategoryBean>) {
        mSubCategoryListAdapter.addSubCategory(subCategory)
        mSubCategoryListAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

    override fun displayError() {
        Snackbar.make(sub_category_cl, R.string.generic_error, Snackbar.LENGTH_LONG).show()
    }

}