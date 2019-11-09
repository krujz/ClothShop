package com.example.clothshop.models

import com.example.clothshop.Utilities.ClothType
import java.io.Serializable

data class ClothModel(val id : String,
                      val cloth : String = "",
                      val type : ClothType,
                      val cost : String,
                      val timesOfBought : String,
                      val isIninvetory : String,
                      val imageID : Int)  : Serializable
