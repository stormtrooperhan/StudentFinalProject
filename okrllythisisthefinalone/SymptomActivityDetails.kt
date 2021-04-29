package com.android.example.okrllythisisthefinalone

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SymptomActivityDetails : AppCompatActivity() {
//    AdapterView.OnItemSelectedListener


    //new variable that checks if the e

    var buttonAdd = findViewById<Button>(R.id.btnAdd)
    private var existingSymptom: Symptom? = null
    //handles our data
    private lateinit var dataMgr: DataManager
    //SEEKBAR handles seekbar non null
    val seekBar = findViewById<SeekBar>(R.id.seekBar3)
    //EDITTEXT value of editTextNotes is the view of EditTextNotes
    val editTextNotes = findViewById<EditText>(R.id.editTextAddNotes)
    //LIST OF SYMPTOMS
    val symptomList = mutableListOf<String>(
        "Chronic Emptiness",
        "Emotional Instability",
        "Abandonment Avoidance",
        "Identity Disturbance",
        "Impulsive Behaviour",
        "Anger",
        "Splitting",
        "Suicidal Idealisation",
        "Dissasociation",
        "Hallucination"
    )

    val spinner: Spinner = findViewById(R.id.spinner3)
    var min = 0
    var max: Int = 100
    var current: Int = 50

    ////////////////////////////////////////////////////////ONCREATE
    override fun onCreate(savedInstanceState: Bundle?) {

        Toast.makeText(this@SymptomActivityDetails, "Please enter your symptomatic information!", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.symptom_activity_details)
        seekBar.progress = max - min
        seekBar.progress = current - min
        //handles seekbar data
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //this handles our data for each context
        dataMgr = DataManager(this)

        //begin database population
        //val of variable symptom is equal to intent of seralialziable data
        val symptom = intent.getSerializableExtra("symptom")
        ///////////////////////////////////// if val of variable symptom is class symptom
        if (symptom is Symptom) {
            //set intent here where symptom selected from spinner is the symptom name
            existingSymptom = symptom
            // value of calender takes isntance from Calender
            //val cal = Calendar.getInstance()
            //datePicker
        }

        fun onStart() {
            super.onStart()
            buttonAdd.isEnabled = dataMgr.hasSymptoms()
        }

        //onClick of Finish button (ActivityDetailsXML),
        //call addSymptomDetail() function

        @Suppress("UNUSED_PARAMETER")
        fun addSymptomDetail(v: View) {
            //value of selectedSymptom becomes item selected from spinner
            val sName = symptomList[spinner.selectedItemPosition]
            //val symptomIntensity takes value of the onProgressChanged callback
            val symptomIntensity = seekBar.progress
            //val of notes takes editTexttoString
            val notes = editTextNotes.toString()
            //val of dateAdded = datePicker action
            //val date1 = Calendar.getInstance().time
            //val formatter = date1 //or use getDateInstance()
            val dateAdded = Date()//formatter.format(date1)
            //value of immutable existing symptoms
            val immutableExistingSymptom = existingSymptom
            //if list is null
            if (immutableExistingSymptom != null) {
                //append sname with sname
                immutableExistingSymptom.sName = sName
                immutableExistingSymptom.symptomIntensity = symptomIntensity
                immutableExistingSymptom.notes = notes
                immutableExistingSymptom.dateAdded = dateAdded
                dataMgr.update(immutableExistingSymptom)
            } else {
                val symptom =
                    existingSymptom ?: Symptom(sName, symptomIntensity, notes, dateAdded)
                dataMgr.add(symptom)
            }
            finish()


        }




//sets adapter for indivdual items
        //fun spiney() {
        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, symptomList)
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        //spinner.adapter = adapter
        //  }

        //overrides the function by checking the progress of seekbar

    }}
