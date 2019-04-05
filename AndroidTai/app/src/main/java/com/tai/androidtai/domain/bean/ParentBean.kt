package com.tai.androidtai.domain.bean

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class ParentBean(
        @ColumnInfo(name = "parent_id")
        @SerializedName("id")
        var id: Int? = 0
)



