
package com.example.kk

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.Button)

        val numberOf = findViewById<TextView>(R.id.NumberOf)
        val myImageView: ImageView = findViewById(R.id.ImageView)
        myImageView.setImageResource(R.drawable.kawa)
        val radioGroup = findViewById<RadioGroup>(R.id.ButtonGroup)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val caffeType = radioButton.text
            Log.i("type", "$caffeType")
            when (caffeType) {
                "Espresso" -> myImageView.setImageResource(R.drawable.espresso);
                "Capuccino" -> myImageView.setImageResource(R.drawable.capuccino);
                "Latte" -> myImageView.setImageResource(R.drawable.latte);
            }
        }

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                numberOf.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        button.setOnClickListener {
            val radioGroup = findViewById<RadioGroup>(R.id.ButtonGroup)
            var caffeType = ""
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val radioButton = findViewById<RadioButton>(checkedId)
                caffeType = radioButton.text.toString()
            }

                val checkBox = findViewById<CheckBox>(R.id.checkBoxGroup)
                var checkBoxChecked = true
                checkBox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        checkBoxChecked = true
                    } else {
                        checkBoxChecked = false
                    }
                }

                val seekBar = findViewById<SeekBar>(R.id.seekBar)

             Toast.makeText(this@MainActivity," $checkBoxChecked, $caffeType", Toast.LENGTH_SHORT).show()
            }
        }
    }