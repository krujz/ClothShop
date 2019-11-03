package com.example.clothshop.Utilities

enum class ClothType
{
    DRESS,SHIRT,SOCKS,SHOES,BELT,BRA,JUMPER,TROUSER,FARMER;

    override fun toString(): String {
        when (this) {
            DRESS -> return "DRESS"
            SHIRT -> return "SHIRT"
            SOCKS -> return "SOCKS"
            SHOES -> return "SHOES"
            BELT -> return "BELT"
            BRA -> return "BRA"
            JUMPER -> return "JUMPER"
            TROUSER -> return "TROUSER"
            else -> return "FARMER"
        }
    }

    companion object
    {
        fun fromString(type : String?) : ClothType?
        {
            when(type)
            {
                "DRESS" -> return DRESS
                "SHIRT" -> return SHIRT
                "SOCKS" -> return SOCKS
                "SHOES" -> return SHOES
                "BELT" -> return BELT
                "BRA" -> return BRA
                "JUMPER" -> return JUMPER
                "TROUSER" -> return TROUSER
                else -> return FARMER
            }
        }
    }

}