package com.example.clothshop.Repository.Enums

import android.graphics.Color

public enum class ServerState{

    Online, Offline;

    override fun toString(): String {
        when (this) {
            Online -> return "A szerver elérhető!"
            else -> return "A szerver nem elérhető!"
        }
    }

    fun toColor(): Int {
        when (this) {
            Online -> return Color.GREEN
            else -> return Color.RED
        }
    }
}