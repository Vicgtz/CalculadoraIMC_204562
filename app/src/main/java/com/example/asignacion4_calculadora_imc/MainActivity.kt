package com.example.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.etPeso) as EditText
        val estatura: EditText = findViewById(R.id.etEstatura) as EditText
        val calcular: Button = findViewById(R.id.btnCalcular) as Button

        var imc: TextView = findViewById(R.id.tvImc) as TextView
        var ran: TextView = findViewById(R.id.tvR) as TextView


        calcular.setOnClickListener {
            val IMC: Float = (peso.text.toString().toFloat()) / (estatura.text.toString()
                .toFloat() * estatura.text.toString().toFloat())

            setColorIMC(IMC, ran)
            imc.setText(IMC.toString())


        }

    }

        fun checkRangeIMC(imc: Float): String{
            return when {
                imc < 18.5 ->   "Bajo peso"
                imc >= 18.5 && imc <= 24.9 ->   "Normal"
                imc >= 25 && imc <= 29.9 ->  "Sobrepeso"
                imc >= 30 && imc <= 34.9 ->  "Obesidad grado 1"
                imc >= 35 && imc <= 39.9 ->  "Obesidad grado 2"
                imc >= 40 -> "Obesidad grado 3"
                else -> return "Numero ilegales"
            }
        }

        fun setColorIMC(imc: Float, text: TextView){
            when {
                imc < 18.5 -> text.setBackgroundResource(R.color.colorGreenish)
                imc >= 18.5 && imc <= 24.9 ->   text.setBackgroundResource(R.color.colorGreen)
                imc >= 25 && imc <= 29.9 ->  text.setBackgroundResource(R.color.colorYellow)
                imc >= 30 && imc <= 34.9 ->  text.setBackgroundResource(R.color.colorOrange)
                imc >= 35 && imc <= 39.9 ->  text.setBackgroundResource(R.color.colorRed)
                imc >= 40 -> text.setBackgroundResource(R.color.colorBrown)
                else -> text.setBackgroundResource(R.color.black)
            }
        }






}