package com.tai.androidtai.dagger.modules

import android.content.Context
import androidx.room.Room
import com.tai.androidtai.domain.cache.EcoMoneyDatabase

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AndroidModule(private val mContext: Context) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mContext
    }

    @Provides
    internal fun provideDatabase(): EcoMoneyDatabase {
        return Room.databaseBuilder(mContext, EcoMoneyDatabase::class.java, "database-name").build()
    }
}
