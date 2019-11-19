package com.trydev.cbr

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.trydev.cbr.contract.PhoneContract
import com.trydev.cbr.presenter.PhonePresenter
import kotlinx.android.synthetic.main.activity_phone.*


class PhoneActivity : AppCompatActivity(), PhoneContract.View {
    private lateinit var editPhone : EditText
    private lateinit var btnPhone : Button
    private lateinit var progressBar : ProgressBar
    private lateinit var presenter : PhonePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        editPhone = edit_phone
        btnPhone = btn_phone
        progressBar = progress_bar
        presenter = PhonePresenter()
        presenter.attachView(this, this)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), 1)
        } else {
            val telemamanger = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val number : String = telemamanger.simSerialNumber
            Log.e("number phone", number)
            editPhone.setText(number)
            presenter.setNumber(number)
        }
    }

    override fun onLoading() {

    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }
}
