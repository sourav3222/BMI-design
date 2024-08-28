package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val height = binding.heightEt.text.toString().toDouble()/100
            val weight = binding.weightEt.text.toString().toDouble()

            val bmi = weight/(height*height)

            binding.BMItv.text = String.format("BMI is : %.2f",bmi)

            binding.bmiTypeTV.text = when(bmi){
                in 1.00 ..18.4->"under Weight"
                in 18.5 .. 25.5->"Normal"
                in 25.6 .. 30.50->"Over Weight"
                in 30.6 .. 50.5->"Obesity"
                else->"He/she  is No More"
            }
        }

    }
}