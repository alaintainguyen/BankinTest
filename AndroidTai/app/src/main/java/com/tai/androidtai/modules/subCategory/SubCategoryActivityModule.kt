package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.dagger.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class SubCategoryActivityModule {

    @Provides
    @PerActivity
    internal fun provideMealDetailsPresenter(): SubCategoryContract.Presenter {
        return SubCategoryPresenter()
    }

}