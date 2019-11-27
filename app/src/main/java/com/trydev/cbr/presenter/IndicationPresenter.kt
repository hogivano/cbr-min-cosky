package com.trydev.cbr.presenter

import android.content.Context
import com.trydev.cbr.contract.IndicationContract
import com.trydev.cbr.model.Indication

class IndicationPresenter : IndicationContract.Presenter{
    private lateinit var view : IndicationContract.View
    private lateinit var context: Context

    override fun getList() {
        var list : ArrayList<Indication>
        list = ArrayList()
        list.add(Indication(1, "Nyeri Dada", 0.7))
        list.add(Indication(2, "Sesak Nafas", 0.6))
        list.add(Indication(3, "Keringat Dingin", 0.5))
        list.add(Indication(4, "Pembengkakan Kaki", 0.7))
        list.add(Indication(5, "Mudah Lelah", 0.6))
        list.add(Indication(6, "Batuk Kering", 0.2))
        list.add(Indication(7, "Sakit Leher/Punggung", 0.4))
        list.add(Indication(8, "Kelainan Bunyi Jatung", 0.2))
        view.listIndication(list)
    }

    override fun attachView(mRootView: IndicationContract.View, context: Context) {
        view = mRootView
        this.context = context
    }

    override fun detachView() {
    }

}