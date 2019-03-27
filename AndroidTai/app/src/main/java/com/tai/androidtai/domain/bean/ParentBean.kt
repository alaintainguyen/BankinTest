package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ParentBean(parcel: Parcel) : Parcelable {

    @SerializedName("id")
    private var mId: Int = 0

    init {
        mId = parcel.readInt()
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
