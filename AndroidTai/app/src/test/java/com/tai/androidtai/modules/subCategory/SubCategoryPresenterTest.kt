package com.tai.androidtai.modules.subCategory

import com.tai.androidtai.domain.bean.CategoryBean
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit

class SubCategoryPresenterTest {

    @get:Rule
    val unitOfWorkRule = MockitoJUnit.rule()!!

    @Mock
    private lateinit var mView: SubCategoryContract.View

    private lateinit var mPresenter: SubCategoryPresenter
    private var mCategoryBean: ArrayList<CategoryBean> = arrayListOf()

    @Before
    fun setUp() {
        mPresenter = SubCategoryPresenter()
        mPresenter.subscribe(mView)

        val categoryBean1 = CategoryBean(1)
        val categoryBean2 = CategoryBean(2)
        val categoryBean3 = CategoryBean(3)

        val parentBean = ParentBean(2)

        categoryBean2.setParent(parentBean)
        mCategoryBean.add(categoryBean1)
        mCategoryBean.add(categoryBean2)
        mCategoryBean.add(categoryBean3)
    }

    @Test
    fun parseSubCategory() {
        // When
        mPresenter.parseSubCategory(mCategoryBean, 2)

        // Verify
        verify(mView, times(1)).displayAllSubCategories(anyList<CategoryBean>() as java.util.ArrayList<CategoryBean>)
    }
}