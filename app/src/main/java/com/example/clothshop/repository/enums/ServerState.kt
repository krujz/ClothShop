package com.example.clothshop.repository.enums

import android.graphics.Color

enum class ServerState
{
    Online, Offline;

    override fun toString(): String {return when (this) {Online -> "Server is online!" else -> "Server is offline!" }}

    fun toColor(): Int {return when (this) {Online -> Color.GREEN else -> Color.RED }}
}