package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ParentBean(parcel: Parcel) {

    @SerializedName("id")
    private var mId: Int = 0

    init {
        mId = parcel.readInt()
    }

    fun getId(): Int? {
        return mId
    }

}
