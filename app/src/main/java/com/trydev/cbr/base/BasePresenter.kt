package com.trydev.cbr.base

import android.content.Context

open class BasePresenter <T: IBaseView> : IBasePresenter<T> {
    var mRootView: T? = null
    private set

    var contex: Context? = null
        private set

    override fun attachView(mRootView: T, context: Context) {
        this.mRootView = mRootView
        this.contex = context
    }

    override fun detachView() {
        mRootView = null
    }

    private val isViewAttached : Boolean
        get() = mRootView != null

    fun checkViewAttached(){
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }
    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")
}