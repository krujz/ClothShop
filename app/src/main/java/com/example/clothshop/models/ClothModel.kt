package com.example.clothshop.models

import com.example.clothshop.utilities.ClothType
import java.io.Serializable

data class ClothModel(var id : String,
                      var cloth : String = "",
                      var type : ClothType,
                      var cost : String,
                      var timesOfBought : String,
                      var isIninvetory : String,
                      var imageID : Int,
                      var stock : String,
                      var orderCount : String)  : Serializable
