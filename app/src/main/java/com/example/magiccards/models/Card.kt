package com.example.magiccards.models

import com.google.gson.annotations.SerializedName

data class Card ( @SerializedName("name") val name: String,
                  @SerializedName("names") val names: ArrayList<String>,
                  @SerializedName("manaCost") val manaCost: String,
                  @SerializedName("cmc") val cmc: Int,
                  @SerializedName("colors") val colors: ArrayList<String>,
                  @SerializedName("colorIdentity") val colorIdentity: ArrayList<String>,
                  @SerializedName("type") val type: String,
                  @SerializedName("supertypes") val supertypes: ArrayList<String>,
                  @SerializedName("types") val types: ArrayList<String>,
                  @SerializedName("rarity") val rarity: String,
                  @SerializedName("set") val set: String,
                  @SerializedName("text") val text: String,
                  @SerializedName("artist") val artist: String,
                  @SerializedName("number") val number: String,
                  @SerializedName("power") val power: String,
                  @SerializedName("toughness") val toughness: String,
                  @SerializedName("layout") val layout: String,
                  @SerializedName("multiverseid") val multiverseid: Int,
                  @SerializedName("imageUrl") val imageUrl: String,
                  @SerializedName("rulings") val rulings: ArrayList<Ruling>,
                  @SerializedName("foreignNames") val foreignNames: ArrayList<ForeignName>,
                  @SerializedName("originalText") val originalText: String,
                  @SerializedName("originalType") val originalType: String,
                  @SerializedName("id") val id: String )
