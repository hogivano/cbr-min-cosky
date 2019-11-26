package com.trydev.cbr.contract

import com.trydev.cbr.base.IBasePresenter
import com.trydev.cbr.base.IBaseView
import com.trydev.cbr.model.Indication

interface HomeContract {
    interface View: IBaseView {
        fun result(solution: String, strIndication: String)
    }

    interface Presenter: IBasePresenter<View> {
        fun setIndication(indication: Indication)
        fun removeIndication(indication: Indication)
        fun find()
    }
}