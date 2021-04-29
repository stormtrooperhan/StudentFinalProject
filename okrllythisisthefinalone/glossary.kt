package com.android.example.okrllythisisthefinalone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.example.okrllythisisthefinalone.databinding.ActivityGlossaryBinding

class glossary : AppCompatActivity() {
    // view bindings
    private var _binding: ActivityGlossaryBinding? = null
    private val binding get() = _binding!!
    // gets a reference to the adapter class
    private var termList = ArrayList<GlossaryTerms>()
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGlossaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

       var rvList = findViewById<View>(R.id.rvlist)

        // define layout manager for the Recycler view
        //binding.rvList.layoutManager = LinearLayoutManager(this)
        // attach adapter to the recycler view
        rvAdapter = RvAdapter(termList)
       // binding.rvList.adapter = rvAdapter


        // creating the new objects
        val term1 = GlossaryTerms(
            "Chronic Emptiness",
            "Chronic feelings of emptiness.",
            false
        )
        val term2 = GlossaryTerms(
            "Emotional Instability",
            "Affective instability due to a marked reactivity of mood (e.g., intense episodic dysphoria, irritability or anxiety usually lasting a few hours and only rarely more than a few days).",
            false
        )
        val term3 = GlossaryTerms(
            "Abandonment Avoidance",
            "Frantic efforts to avoid real or imagined abandonment. Note: Do not include suicidal or self-mutilating behaviour covered in criterion 5.",
            false
        )
        val term4 = GlossaryTerms(
            "Identity Disturbance",
            "Identity disturbance: markedly and persistently unstable self-image or sense of self.",
            false
        )
        val term5 = GlossaryTerms(
            "Impulsive Behaviour",
            "Impulsivity in at least 2 areas that are potentially self-damaging (e.g., spending, sex, substance abuse, reckless driving, binge eating). Note: Do not include suicidal or self-mutilating behaviour covered in criterion 5.",
            false
        )
        val term6 = GlossaryTerms(
            "Anger",
            "Inappropriate, intense anger or difficulty controlling anger (e.g., frequent displays of temper, constant anger, recurrent physical fights).",
            false
        )
        val term7 = GlossaryTerms(
            "Splitting",
            "Python is a high-level, general-purpose and a very popular programming language.",
            false
        )
        val term8 = GlossaryTerms(
            "Suicidal Idealisation",
            "Recurrent suicidal behaviour, gestures or threats, or self-mutilating behaviour.",
            false
        )

        // add items to list
        termList.add(term1)
        termList.add(term2)
        termList.add(term3)
        termList.add(term4)
        termList.add(term5)
        termList.add(term6)
        termList.add(term7)
        termList.add(term8)


        rvAdapter.notifyDataSetChanged()

    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}