package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ResourceBean : Parcelable {

    @SerializedName("resources")
    var mCategoryBean: ArrayList<CategoryBean> = arrayListOf()

    private constructor(parcel: Parcel) {
        mCategoryBean = parcel.createTypedArrayList(CategoryBean.CREATOR) as ArrayList<CategoryBean>
    }

    constructor(resource: ArrayList<CategoryBean>) {
        mCategoryBean = resource
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList<CategoryBean>(mCategoryBean)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getResultList(): ArrayList<CategoryBean> {
        return mCategoryBean
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ResourceBean> = object : Parcelable.Creator<ResourceBean> {
            override fun createFromParcel(parcel: Parcel): ResourceBean {
                return ResourceBean(parcel)
            }

            override fun newArray(size: Int): Array<ResourceBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}

