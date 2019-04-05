package com.tai.androidtai.domain.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "resources")
class CategoryBean {

    @PrimaryKey
    @ColumnInfo(name = "resource_id")
    @SerializedName("id")
    private var mId: Int = 0

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private var mName: String? = null

    @ColumnInfo(name = "parent")
    @SerializedName("parent")
    private var mParent: ParentBean? = null

    fun getId(): Int {
        return mId
    }

    fun getName(): String? {
        return mName
    }

    fun getParent(): ParentBean? {
        return mParent
    }

    fun setParent(parent: ParentBean) {
        mParent = parent
    }

    fun setId(id: Int) {
        mId = id
    }

    fun setName(name: String) {
        mName = name
    }

}


