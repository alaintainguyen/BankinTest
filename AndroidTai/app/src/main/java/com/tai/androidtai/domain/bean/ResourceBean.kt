package com.tai.androidtai.domain.bean

import com.google.gson.annotations.SerializedName

class ResourceBean {

    @SerializedName("resources")
    var mCategoryBean: ArrayList<CategoryBean> = arrayListOf()

    fun getResultList(): ArrayList<CategoryBean> {
        return mCategoryBean
    }
}

