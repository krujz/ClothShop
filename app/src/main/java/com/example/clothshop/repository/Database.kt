package com.example.clothshop.repository

import com.example.clothshop.repository.connection.SQLConnection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

abstract class Database
{
    protected var querry: String? = null
    private var prepStatement: PreparedStatement? = null

    private var resultSet: ResultSet? = null
    protected fun getResultSet(): ResultSet? { return this.resultSet }

    fun dispose()
    {
        try {resultSet!!.close()} catch (e: SQLException) {}

        try {prepStatement!!.close()} catch (e: SQLException) {}
    }
    @Throws(SQLException::class)
    protected open fun runDatabaseQuerry(kod: String)
    {
        this.prepStatement = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.resultSet = this.prepStatement!!.executeQuery()
    }

    @Throws(SQLException::class)
    protected open fun runDatabseUpload(kod: String)
    {
        this.prepStatement = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.prepStatement!!.execute()
    }
}