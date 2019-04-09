package com.tai.androidtai.domain.cache

import androidx.room.*
import com.tai.androidtai.domain.bean.CategoryBean
import io.reactivex.Observable

@Database(entities = [CategoryBean::class], version = 1)
abstract class EcoMoneyDatabase : RoomDatabase() {
    abstract fun cachedResourcesDao(): CachedResourcesDao

    @Dao
    interface CachedResourcesDao {

        @Query("SELECT * FROM resources WHERE parent_id = :id")
        fun getSubCategory(id: Int): Observable<List<CategoryBean>>

        @Query("SELECT * FROM resources WHERE parent_id IS NULL")
        fun getMainCategory(): List<CategoryBean>

        @Insert
        fun insertAll(resources: List<CategoryBean>)

        @Query("DELETE FROM resources")
        fun deleteAll()

    }
}
