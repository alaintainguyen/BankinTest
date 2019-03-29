package com.tai.androidtai.modules.dashboard

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.cache.EcoMoneyDatabase
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

        dashboard_refresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary))

        dashboard_refresh.setOnRefreshListener {
            mDashboardListAdapter.clear()
            mPresenter.getInfo()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

    override fun displayError() {
        dashboard_refresh.isRefreshing = false
        Snackbar.make(dashboard_refresh, R.string.generic_error, Snackbar.LENGTH_LONG).show()
    }

    override fun displayInformation(allCategories: ArrayList<CategoryBean>) {
        dashboard_refresh.isRefreshing = false
        mDashboardListAdapter.addInformation(allCategories)
        mDashboardListAdapter.notifyDataSetChanged()
    }

}