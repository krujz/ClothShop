package com.example.clothshop.models

import com.example.clothshop.Utilities.ClothType
import java.io.Serializable

data class ClothModel(val cloth : String = "",
                      val type : ClothType,
                      val cost : Int,
                      val isBought : Boolean,
                      val isIninvetory : Boolean,
                      val isOrdered : Boolean,
                      val isDeleted : Boolean)  : Serializable
