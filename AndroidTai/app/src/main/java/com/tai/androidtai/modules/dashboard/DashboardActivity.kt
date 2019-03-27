package com.tai.androidtai.modules.dashboard

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardContract.View {

    companion object {
        const val NUMBER_OF_COLUMN: Int = 2
    }

    @Inject
    lateinit var mPresenter: DashboardContract.Presenter

    private lateinit var mDashboardListAdapter: DashboardListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)
        mDashboardListAdapter = DashboardListAdapter(mPresenter)
        dashboard_rv.setHasFixedSize(true)
        dashboard_rv.layoutManager = GridLayoutManager(this, NUMBER_OF_COLUMN)
        dashboard_rv.adapter = mDashboardListAdapter
        mPresenter.getInfo()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

    override fun displayInformation(allCategories: ArrayList<CategoryBean>) {
        mDashboardListAdapter.addInformation(allCategories)
        mDashboardListAdapter.notifyDataSetChanged()
    }

}