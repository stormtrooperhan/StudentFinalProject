package com.android.example.okrllythisisthefinalone

import java.io.Serializable
import java.util.*

class Symptom(
    var sName: String,
    var symptomIntensity: Int,
    var notes: String,
    var dateAdded: Date,
    var sId: Int = 0 ,
    var heartBeatValue : Int = 0
) : Serializable {}