package com.example.clothshop.Repository

import android.annotation.SuppressLint
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.ArrayList

open abstract class Database
{

    @SuppressLint("SimpleDateFormat")
    protected val dateFormatHosszu: DateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss") as DateFormat
    @SuppressLint("SimpleDateFormat")
    protected val dateFormatRovid: DateFormat = SimpleDateFormat("yyyy.MM.dd")

    protected var querry: String? = null
    protected var querries: ArrayList<String>? = null

    private var prepStatement: PreparedStatement? = null
    private var prepStatementHelper: PreparedStatement? = null

    private var resultSet: ResultSet? = null
    protected fun getResultSet(): ResultSet? {
        return this.resultSet
    }

    private var resultSetHelper: ResultSet? = null
    protected fun getResultSetHelper(): ResultSet? {
        return this.resultSetHelper
    }
    fun dispose() {

        try {
            resultSet!!.close()
        } catch (e: SQLException) {
            //log error
        }

        try {
            prepStatement!!.close()
        } catch (e: SQLException) {
            //log error
        }
    }

    protected open fun disposeHelper() {

        try {
            resultSetHelper!!.close()
        } catch (e: SQLException) {
            //log error
        }


        try {
            prepStatementHelper!!.close()
        } catch (e: SQLException) {
            //log error
        }


    }
    @Throws(SQLException::class)
    protected open fun runDatabaseQuerry(kod: String) {

        this.prepStatement = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.resultSet = this.prepStatement!!.executeQuery()
    }

    @Throws(SQLException::class)
    protected open fun runDatabaseQuerryHelper(kod: String) {
        this.prepStatementHelper = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.resultSetHelper = this.prepStatementHelper!!.executeQuery()
    }

    @Throws(SQLException::class)
    protected open fun runDatabseUpload(kod: String) {
        this.prepStatement = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.prepStatement!!.execute()
    }

    @Throws(SQLException::class)
    protected open fun runDatabaseUploadHelper(kod: String) {
        this.prepStatementHelper = SQLConnection.conDatabase!!.prepareStatement(kod)
        this.prepStatementHelper!!.execute()
    }

}