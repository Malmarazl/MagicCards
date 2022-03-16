package com.example.magiccards.models

import com.google.gson.annotations.SerializedName

data class ParentCard (@SerializedName("card") val parentCard: Card )