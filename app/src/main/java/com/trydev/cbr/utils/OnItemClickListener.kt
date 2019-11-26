package com.trydev.cbr.utils

import com.trydev.cbr.model.Indication

interface OnCheckedIndicationListener {
    fun onChecked(indication: Indication)
    fun notChecked(indication: Indication)
}