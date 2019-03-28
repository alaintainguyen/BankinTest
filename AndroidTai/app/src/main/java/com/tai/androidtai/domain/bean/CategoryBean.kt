package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class CategoryBean : Parcelable {

    @SerializedName("id")
    private var mId: Int = 0

    @SerializedName("name")
    private var mName: String? = null

    @SerializedName("parent")
    private var mParent: ParentBean? = null

    private constructor(parcel: Parcel) {
        mId = parcel.readInt()
        mName = parcel.readString()
        mParent = parcel.readParcelable(ParentBean::class.java.classLoader)
    }

    constructor(id: Int) {
        mId = id
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(mId)
        dest.writeString(mName)
        dest.writeParcelable(mParent, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getId(): Int {
        return mId
    }

    fun getName(): String? {
        return mName
    }

    fun getParent(): ParentBean? {
        return mParent
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CategoryBean> = object : Parcelable.Creator<CategoryBean> {
            override fun createFromParcel(parcel: Parcel): CategoryBean {
                return CategoryBean(parcel)
            }

            override fun newArray(size: Int): Array<CategoryBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}
