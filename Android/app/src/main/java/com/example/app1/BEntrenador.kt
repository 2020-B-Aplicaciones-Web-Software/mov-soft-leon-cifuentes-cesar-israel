package com.example.app1

import android.os.Parcel
import android.os.Parcelable

class BEntrenador(
    val nombre:String?,
    val descipcion: String?,
    val liga: DLiga?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(DLiga::class.java.classLoader)
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descipcion)
        parcel.writeParcelable(liga,flags)
    }
    override fun toString(): String {
        return "${nombre}-${descipcion}"
    }



    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BEntrenador> {
        override fun createFromParcel(parcel: Parcel): BEntrenador {
            return BEntrenador(parcel)
        }

        override fun newArray(size: Int): Array<BEntrenador?> {
            return arrayOfNulls(size)
        }
    }
}