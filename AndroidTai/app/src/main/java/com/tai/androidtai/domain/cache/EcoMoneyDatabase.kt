package com.tai.androidtai.domain.cache

import androidx.room.*
import com.tai.androidtai.domain.bean.CategoryBean

@Database(entities = [CategoryBean::class], version = 1)
abstract class EcoMoneyDatabase : RoomDatabase() {
    abstract fun cachedResourcesDao(): CachedResourcesDao

    @Dao
    interface CachedResourcesDao {

        @Query("SELECT * FROM resources")
        fun getAll(): List<CategoryBean>

//        @Query("SELECT * FROM resources WHERE parent == null")
//        fun getMainCategories(): List<CategoryBean>

        @Insert
        fun insertAll(resources: List<CategoryBean>)

        @Query("DELETE FROM resources")
        fun deleteAll()

    }
}
