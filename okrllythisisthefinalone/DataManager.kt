package com.android.example.okrllythisisthefinalone

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.*


class DataManager(context: Context) {
    //declare database as db, call sql connect and creation database
    private val db: SQLiteDatabase =
        context.openOrCreateDatabase("SymptomDetailDB", Context.MODE_PRIVATE, null)

    //initialise class to use a query identifier
    init {
        //create table if non exists
        val symptomCreateQuery =
            "CREATE TABLE IF NOT EXISTS 'Symptoms'('Sname' TEXT NOT NULL," +
                    "'SymptomIntensity' INTEGER, " +
                    " 'Notes' TEXT ,  " +
                    "'DateAdded' INTEGER, " +
                    "'SID' INTEGER NOT NULL PRIMARY KEY AUTOINCRAMENT" +
                    "HeartBeatValue' INTEGER  "

        //execute database search
        db.execSQL(symptomCreateQuery)
    }


    //function add ( sym
    fun add(symptom: Symptom) {
        //on add value of query becomes an intertion into symptoms with values from the class symptom
        val query = "INSERT INTO Symptoms (sName,SymptomIntensity, Notes, DateAdded, SID) " +
                "VALUES ('${symptom.sName}','${symptom.symptomIntensity}','${symptom.notes}',${symptom.dateAdded}, '${symptom.sId}+1' )"
        //execute this sql query
        db.execSQL(query)

    }

    // function update symptom object in Symptom class
    fun update(symptom: Symptom) {
        //val of contentValues = empty array of values from defaults set
        val contentValues = ContentValues()
        ////put the current value of content value into the coulmn called sname for symptom object sname
        contentValues.put("Sname", symptom.sName)
        contentValues.put("SymptomIntensity", symptom.notes)
        contentValues.put("Notes", symptom.notes)
        contentValues.put("DateAdded", symptom.dateAdded.toString())
        contentValues.put("HeartBeatValue", symptom.heartBeatValue)
        //val of arguement = array of sId's
        val args = arrayOf(symptom.sId.toString())
        //database update table symptoms and put the conent values into where ID is unknown
        db.update("Symptoms", contentValues, "Id = ?", args)
    }



    //check if symptom already exists as boolean
    fun hasSymptoms(): Boolean {
        //value of cursor becomes a db query from table symptoms, select column from symptoms table, argument none
        val cursor = db.rawQuery("SELECT * FROM Symptoms", null)
        return if (cursor.count > 0) {
            cursor.close()
            true
        } else {
            cursor.close()
            false
        }
    }

    //list all symptoms from list of symptoms
    fun allSymptoms(): List<Symptom> {
        //where symptms is the mutable list of symptoms
        val symptoms = mutableListOf<Symptom>()
        //value of cursor is db query select from symptoms
        val cursor = db.rawQuery("SELECT * FROM Symptoms", null)
        //move cursor to first row
        if (cursor.moveToFirst()) {
            do {
                val sName = cursor.getString(cursor.getColumnIndex("Sname"))
                val symptomIntensity = cursor.getInt(cursor.getColumnIndex("SymptomIntensity"))
                val notes = cursor.getString(cursor.getColumnIndex("Notes"))
                val dateLong = cursor.getLong(cursor.getColumnIndex("DateAdded"))
                val dateAdded = Date(dateLong)
                val sID = cursor.getInt((cursor.getColumnIndex("SID")))
                val symptom = Symptom(sName, symptomIntensity, notes, dateAdded, sID)
                symptoms.add(symptom)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return symptoms
    }



}














