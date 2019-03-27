package com.tai.androidtai.modules.subCategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.CategoryBean
import kotlinx.android.synthetic.main.item_display_info.view.*
import java.util.*

class SubCategoryListAdapter : RecyclerView.Adapter<SubCategoryListAdapter.SubCategoryViewHolder>() {

    private val mItems: ArrayList<CategoryBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display_info, parent, false)
        return SubCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val resultBean = mItems[position]
        holder.itemView.name.text = resultBean.getName()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun addInformation(categories: ArrayList<CategoryBean>) {
        mItems.addAll(categories)
    }

    inner class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.name
        }
    }
}
