package com.trydev.cbr.contract

import com.trydev.cbr.base.IBasePresenter
import com.trydev.cbr.base.IBaseView

interface PhoneContract {
    interface View: IBaseView {

    }

    interface Presenter : IBasePresenter<View>{
        fun setNumber(num: String)
    }
}