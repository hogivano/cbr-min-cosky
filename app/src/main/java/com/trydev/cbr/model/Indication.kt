package com.trydev.cbr.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "indication")
data class Indication(
    var code : Int,
    var name: String,
    var value : Double
) : Parcelable