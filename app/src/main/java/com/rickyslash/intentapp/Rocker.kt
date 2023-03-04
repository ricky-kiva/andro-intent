package com.rickyslash.intentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*Send Data with Parcelable*/
// Parcelable enable developer to send an object (ex: ArrayList, dll) from Activity to another Activity

// 'data class' is a class that doesn't depend on another class
// it's used to save 'model data' (attributes) as ab object, like POJO (Plain Old Java Object)

// add annotation '@Parcelize' & ': Parcelable' to enable 'Parcelize with plugin'
@Parcelize
data class Rocker(
    val name: String?,
    val band: String?,
    val year: Int?,
    val album: String?
) : Parcelable

/* Parcelize without plugin

// add ': Parcelable' to the 'end' of 'data class constructor' to 'auto-generate' component for parcelable
data class Rocker(
    val name: String?,
    val band: String?,
    val year: Int?,
    val album: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(band)
        parcel.writeValue(year)
        parcel.writeString(album)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rocker> {
        override fun createFromParcel(parcel: Parcel): Rocker {
            return Rocker(parcel)
        }

        override fun newArray(size: Int): Array<Rocker?> {
            return arrayOfNulls(size)
        }
    }
}
*/