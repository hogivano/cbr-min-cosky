package com.trydev.cbr.base

interface IBaseView {
    fun onLoading()
    fun onError(msg: String)
    fun onSuccess(msg: String)
}