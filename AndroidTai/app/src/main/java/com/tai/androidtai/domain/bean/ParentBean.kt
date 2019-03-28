package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ParentBean : Parcelable {

    @SerializedName("id")
    private var mId: Int = 0

    private constructor(parcel: Parcel) {
        mId = parcel.readInt()
    }

    constructor(id: Int) {
        mId = id
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(mId)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getId(): Int? {
        return mId
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ParentBean> = object : Parcelable.Creator<ParentBean> {
            override fun createFromParcel(parcel: Parcel): ParentBean {
                return ParentBean(parcel)
            }

            override fun newArray(size: Int): Array<ParentBean?> {
                return arrayOfNulls(size)
            }
        }
    }

}
