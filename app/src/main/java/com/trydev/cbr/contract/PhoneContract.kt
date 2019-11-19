package com.trydev.cbr.contract

import com.trydev.cbr.base.IBaseView

interface PhoneContract {
    interface View:IBaseView {

    }

    interface Presenter {
        fun setNumber(num: String)
    }
}