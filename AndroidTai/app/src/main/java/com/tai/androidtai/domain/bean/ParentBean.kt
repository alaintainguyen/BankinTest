package com.tai.androidtai.domain.bean

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class ParentBean(id: Int) {

    @ColumnInfo(name = "parent_id")
    @SerializedName("id")
    private var mId: Int? = id

    fun getId(): Int? {
        return mId
    }

    fun setId(id: Int) {
        mId = id
    }

}