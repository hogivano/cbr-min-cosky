package com.trydev.cbr.base

import android.content.Context

interface IBasePresenter<in V: IBaseView> {
    fun attachView(mRootView: V, context: Context)
    fun detachView()
}
