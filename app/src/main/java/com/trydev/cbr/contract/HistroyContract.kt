package com.trydev.cbr.contract

import com.trydev.cbr.base.IBasePresenter
import com.trydev.cbr.base.IBaseView
import com.trydev.cbr.model.History

interface HistoryContract {
    interface View: IBaseView {
        fun listHistory(list: ArrayList<History>)
    }

    interface Presenter: IBasePresenter<View> {
        fun getList()
    }
}