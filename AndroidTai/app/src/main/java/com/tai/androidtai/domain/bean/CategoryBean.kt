package com.tai.androidtai.domain.bean

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "resources")
data class CategoryBean(
        @PrimaryKey
        @ColumnInfo(name = "resource_id")
        @SerializedName("id")
        var id: Int = 0,

        @ColumnInfo(name = "name")
        @SerializedName("name")
        var name: String? = null,

        @Embedded
        @SerializedName("parent")
        var parent: ParentBean? = null
)