package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ParentBean {

    @SerializedName("id")
    private var mId: Int = 0

    fun getId(): Int? {
        return mId
    }

}
