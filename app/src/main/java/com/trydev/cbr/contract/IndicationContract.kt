package com.trydev.cbr.contract

import com.trydev.cbr.base.IBasePresenter
import com.trydev.cbr.base.IBaseView
import com.trydev.cbr.model.Indication

interface IndicationContract {
    interface View : IBaseView {
        fun listIndication(list : ArrayList<Indication>)
    }

    interface Presenter : IBasePresenter<View>{
        fun getList()
    }
}