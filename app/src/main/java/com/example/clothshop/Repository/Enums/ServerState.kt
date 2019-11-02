package com.example.clothshop.Repository.Enums

import android.graphics.Color

enum class ServerState{

    Online, Offline;

    override fun toString(): String {
        when (this) {
            Online -> return "Server is online!"
            else -> return "Server is offline!"
        }
    }

    fun toColor(): Int {
        when (this) {
            Online -> return Color.GREEN
            else -> return Color.RED
        }
    }
}