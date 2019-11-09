package com.example.clothshop.models

import com.example.clothshop.Utilities.ClothType
import java.io.Serializable

data class ClothModel(val cloth : String = "",
                      val type : ClothType,
                      val cost : String,
                      val isBought : String,
                      val isIninvetory : String,
                      val isOrdered : String,
                      val isDeleted : String,
                      val imageID : Int)  : Serializable
