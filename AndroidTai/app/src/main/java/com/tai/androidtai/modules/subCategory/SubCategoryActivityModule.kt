package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.usecase.SubCategoryUseCase
import dagger.Module
import dagger.Provides

@Module
class SubCategoryActivityModule {

    @Provides
    @PerActivity
    internal fun provideMealDetailsPresenter(subCategoryUseCase: SubCategoryUseCase): SubCategoryContract.Presenter {
        return SubCategoryPresenter(subCategoryUseCase)
    }

}