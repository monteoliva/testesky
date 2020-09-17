package br.com.monteoliva.testesky.model.gson

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Master(@SerializedName("items") @Expose val items: MutableList<Item>? = null) : Parcelable