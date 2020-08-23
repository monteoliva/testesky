package br.com.monteoliva.testesky.model.gson

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(@SerializedName("title")         @Expose val title: String? = null,
                @SerializedName("overview")      @Expose val overview: String? = null,
                @SerializedName("duration")      @Expose val duration: String? = null,
                @SerializedName("release_year")  @Expose val releaseYear: String? = null,
                @SerializedName("cover_url")     @Expose val coverUrl: String? = null,
                @SerializedName("backdrops_url") @Expose val backdropsUrl: MutableList<String>? = null,
                @SerializedName("id")            @Expose val id: String? = null) : Parcelable