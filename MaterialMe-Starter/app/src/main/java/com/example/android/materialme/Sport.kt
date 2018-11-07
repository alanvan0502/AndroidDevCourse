/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme

import android.os.Parcel
import android.os.Parcelable

/**
 * Data model for each row of the RecyclerView
 */
internal class Sport
/**
 * Constructor for the Sport data model.
 *
 * @param title The name if the sport.
 * @param info Information about the sport.
 */
(// Member variables representing the title and information about the sport.
        /**
         * Gets the title of the sport.
         *
         * @return The title of the sport.
         */
        val title: String,
        /**
         * Gets the info about the sport.
         *
         * @return The info about the sport.
         */
        val info: String,
        val imageResource: Int): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(info)
        dest?.writeInt(imageResource)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sport> {
        override fun createFromParcel(parcel: Parcel): Sport {
            return Sport(parcel)
        }

        override fun newArray(size: Int): Array<Sport?> {
            return arrayOfNulls<Sport?>(size)
        }
    }

}