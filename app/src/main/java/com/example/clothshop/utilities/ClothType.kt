package com.example.clothshop.utilities

enum class ClothType
{
    DRESS,SHIRT,SOCKS,SHOES,BELT,BRA,JUMPER,TROUSER,FARMER;

    override fun toString(): String
    {
        return when (this)
        {
            DRESS -> "DRESS"
            SHIRT -> "SHIRT"
            SOCKS -> "SOCKS"
            SHOES -> "SHOES"
            BELT -> "BELT"
            BRA -> "BRA"
            JUMPER -> "JUMPER"
            TROUSER -> "TROUSER"
            else -> "FARMER"
        }
    }

    companion object
    {
        fun fromString(type : String?) : ClothType?
        {
            return when(type!!.trim())
            {
                "DRESS" -> DRESS
                "SHIRT" -> SHIRT
                "SOCKS" -> SOCKS
                "SHOES" -> SHOES
                "BELT" -> BELT
                "BRA" -> BRA
                "JUMPER" -> JUMPER
                "TROUSER" -> TROUSER
                else -> FARMER
            }
        }
    }
}