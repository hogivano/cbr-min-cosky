package com.trydev.cbr.presenter

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.trydev.cbr.base.BasePresenter
import com.trydev.cbr.contract.PhoneContract

class PhonePresenter: BasePresenter<PhoneContract.View>(),PhoneContract.Presenter {
    private lateinit var view : PhoneContract.View
    private lateinit var context : Context
    private lateinit var mAuth : FirebaseAuth

    override fun attachView(mRootView: PhoneContract.View, context: Context) {
        super.attachView(mRootView, context)
        this.view = mRootView
        this.context = context
        this.mAuth = FirebaseAuth.getInstance()
    }

    override fun detachView() {
        super.detachView()
    }

    override fun setNumber(num: String) {
        view.onLoading()
        mAuth.signInWithCustomToken(num).addOnCompleteListener {task ->
            if (task.isSuccessful){
                view.onSuccess("successful")
            } else {
                view.onError("check error")
            }
        }
    }

}