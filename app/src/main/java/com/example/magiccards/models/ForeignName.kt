package com.example.magiccards.models

import com.google.gson.annotations.SerializedName

data class ForeignName (@SerializedName("name") val name: String,
                        @SerializedName("language") val language: String,
                        @SerializedName("multiverseid") val multiverseid: Int )