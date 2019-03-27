package com.tai.androidtai.dagger.modules

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.modules.dashboard.DashboardActivity
import com.tai.androidtai.modules.dashboard.DashboardActivityModule
import com.tai.androidtai.modules.subCategory.SubCategoryActivity
import com.tai.androidtai.modules.subCategory.SubCategoryActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(DashboardActivityModule::class))
    internal abstract fun bindDashboardActivity(): DashboardActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SubCategoryActivityModule::class))
    internal abstract fun bindSubCategoryActivity(): SubCategoryActivity

}