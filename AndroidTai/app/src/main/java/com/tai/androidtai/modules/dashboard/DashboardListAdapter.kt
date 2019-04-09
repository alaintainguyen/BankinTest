package com.tai.androidtai.modules.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.CategoryBean
import kotlinx.android.synthetic.main.item_display_info.view.*
import java.util.*

class DashboardListAdapter internal constructor(private val mPresenter: DashboardContract.Presenter) : RecyclerView.Adapter<DashboardListAdapter.DashboardViewHolder>() {

    private val mItems: ArrayList<CategoryBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display_info, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val resultBean = mItems[position]
        holder.itemView.name.text = resultBean.name
        holder.itemView.layout.setOnClickListener {
            mPresenter.goToSubCategory(resultBean.id, resultBean.name)
        }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun addInformation(categories: List<CategoryBean>) {
        mItems.addAll(categories)
    }

    fun clear() {
        mItems.clear()
    }

    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.name
            itemView.layout
        }
    }
}
