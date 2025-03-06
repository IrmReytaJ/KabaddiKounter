package com.example.kabaddikounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scoreViewModel = ViewModelProvider(this)[ScoreViewModel::class.java]

        // Inisialisasi UI
        val tvScoreA = findViewById<TextView>(R.id.textView2)
        val tvScoreB = findViewById<TextView>(R.id.textView3)
        val buttonPlusOneA = findViewById<Button>(R.id.button)
        val buttonPlusTwoA = findViewById<Button>(R.id.button2)
        val buttonPlusOneB = findViewById<Button>(R.id.button3)
        val buttonPlusTwoB = findViewById<Button>(R.id.button4)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        // Mengamati perubahan skor
        scoreViewModel.scoreA.observe(this, Observer { tvScoreA.text = it.toString() })
        scoreViewModel.scoreB.observe(this, Observer { tvScoreB.text = it.toString() })

        // listener untuk tombol
        buttonPlusOneA.setOnClickListener { scoreViewModel.addScoreA(1) }
        buttonPlusTwoA.setOnClickListener { scoreViewModel.addScoreA(2) }
        buttonPlusOneB.setOnClickListener { scoreViewModel.addScoreB(1) }
        buttonPlusTwoB.setOnClickListener { scoreViewModel.addScoreB(2) }
        buttonReset.setOnClickListener { scoreViewModel.resetScores() }
    }
}