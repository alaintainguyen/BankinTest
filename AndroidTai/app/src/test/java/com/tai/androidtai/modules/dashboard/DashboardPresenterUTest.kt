package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.CategoryBean
import com.tai.androidtai.domain.bean.ResourceBean
import com.tai.androidtai.domain.usecase.DashboardUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit

class DashboardPresenterUTest {

    @get:Rule
    val unitOfWorkRule = MockitoJUnit.rule()!!

    @Mock
    private lateinit var mRouter: DashboardContract.Router

    @Mock
    private lateinit var mView: DashboardContract.View

    @Mock
    private lateinit var mDashboardUseCase: DashboardUseCase

    private lateinit var mPresenter: DashboardPresenter
    private lateinit var mResourceBean: ResourceBean
    private var mCategoryBean: ArrayList<CategoryBean> = arrayListOf()

    @Before
    fun setUp() {
        mPresenter = DashboardPresenter(mRouter, mDashboardUseCase)
        mPresenter.subscribe(mView)

        val categoryBean1 = CategoryBean(1)
        val categoryBean2 = CategoryBean(2)
        val categoryBean3 = CategoryBean(3)

        mCategoryBean.add(categoryBean1)
        mCategoryBean.add(categoryBean2)
        mCategoryBean.add(categoryBean3)

        mResourceBean = ResourceBean(mCategoryBean)
    }

    @Test
    fun getInformation_success() {
        Mockito.doAnswer { invocation ->
            val subscriber = invocation.arguments[0] as DashboardPresenter.GetInfoSubscriber
            subscriber.onNext(mResourceBean)
            null
        }.`when`(mDashboardUseCase).execute(ArgumentMatchers.any(DashboardPresenter.GetInfoSubscriber::class.java))

        // When
        mPresenter.getInfo()

        // Verify
        verify(mView).displayInformation(mCategoryBean)
    }

    @Test
    fun getInformation_error() {
        Mockito.doAnswer { invocation ->
            val subscriber = invocation.arguments[0] as DashboardPresenter.GetInfoSubscriber
            subscriber.onError(Throwable())
            null
        }.`when`(mDashboardUseCase).execute(ArgumentMatchers.any(DashboardPresenter.GetInfoSubscriber::class.java))

        // When
        mPresenter.getInfo()

        // Verify
        verify(mView).displayError()
    }

    @Test
    fun goToSubCategory() {
        // Given
        Mockito.doAnswer { invocation ->
            val subscriber = invocation.arguments[0] as DashboardPresenter.GetInfoSubscriber
            subscriber.onNext(mResourceBean)
            null
        }.`when`(mDashboardUseCase).execute(ArgumentMatchers.any(DashboardPresenter.GetInfoSubscriber::class.java))
        mPresenter.getInfo()

        // When
        mPresenter.goToSubCategory(1, "someName")

        // Verify
        verify(mRouter).goToSubCategory(1, "someName", mCategoryBean, mView)
    }

}

