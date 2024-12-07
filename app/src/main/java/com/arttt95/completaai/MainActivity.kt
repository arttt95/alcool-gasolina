package com.arttt95.completaai

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inicializarComponentesInterface()
        btnCalcular.setOnClickListener{
            calcularMelhorPreco()
        }

    }

    private fun calcularMelhorPreco() {

        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if (resultadoValidacao) {

            val precoAlcoolDouble = precoAlcool.toDouble()
            val precoGasolinaDouble = precoGasolina.toDouble()
            val res = precoAlcoolDouble / precoGasolinaDouble

            /*textResultado.text = res.toString()*/

            if (res >= 0.7) {
                textResultado.text = "Melhor utilizar gasolina"
            } else {
                textResultado.text = "Melhor utilizar álcool"
            }

        }

    }

    private fun inicializarComponentesInterface() {

        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if(pAlcool.isEmpty()) {
            textInputAlcool.error = "Campo obrigatório, por favor digite o valor!"
            return false
        } else if (pGasolina.isEmpty()) {
            textInputGasolina.error = "Campo obrigatório, por favor digite um valor!"
            return false
        } else if (pAlcool.isEmpty() && pGasolina.isEmpty()) {
            textInputAlcool.error = "Campo obrigatório, por favor digite o valor!"
            textInputGasolina.error = "Campo obrigatório, por favor digite um valor!"
            return false
        } else {
            return true
        }



    }
}