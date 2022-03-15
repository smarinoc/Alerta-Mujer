package com.udea.alerta.alerta

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.content.Intent
import android.provider.ContactsContract
import android.widget.Toast
import android.net.Uri
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udea.alerta.R
import com.udea.alerta.calculator.Calculator
import com.udea.alerta.ui.MainActivity
import com.udea.alerta.viewModel.GuardianViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class Alerta : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        var etMsj: String? = null
        var btnEnviar: Button? = null
        var count = 0
        var count2 = 0
        val resultado = findViewById<TextView>(R.id.resultadoText)
        val model: GuardianViewModel by viewModels()

        resultado.text = "0"
        operacion = Calculator.SIN_OPERACION

        var uno : Button ?= null
        var dos : Button ?= null
        var tres : Button ?= null
        var cuatro : Button ?= null
        var cinco : Button ?= null
        var seis : Button ?= null
        var siete : Button ?= null
        var ocho : Button ?= null
        var nueve : Button ?= null
        var suma : Button ?= null
        var resta : Button ?= null
        var multiplicar : Button ?= null
        var dividir : Button ?= null
        var cero : Button ?= null
        var punto : Button ?= null
        var clear : Button ?= null
        var igual : Button ?= null

        uno = findViewById(R.id.unoBtn)
        dos = findViewById(R.id.dosBtn)
        tres = findViewById(R.id.tresBtn)
        cuatro = findViewById(R.id.cuatroBtn)
        cinco = findViewById(R.id.cincoBtn)
        seis = findViewById(R.id.seisBtn)
        siete = findViewById(R.id.sieteBtn)
        ocho = findViewById(R.id.ochoBtn)
        nueve = findViewById(R.id.nueveBtn)
        cero = findViewById(R.id.ceroBtn)
        suma = findViewById(R.id.sumaBtn)
        resta = findViewById(R.id.restaBtn)
        multiplicar = findViewById(R.id.multiplicarBtn)
        dividir = findViewById(R.id.divisionBtn)
        punto = findViewById(R.id.puntoBtn)
        clear = findViewById(R.id.clearBtn)
        igual = findViewById(R.id.igualBtn)

        uno.setOnClickListener { count = 0
            count2 = 0
            numberPressed("1") }
        dos.setOnClickListener { count = 0
            count2 = 0
            numberPressed("2") }
        tres.setOnClickListener { count = 0
            count2 = 0
            numberPressed("3") }
        cuatro.setOnClickListener { count = 0
            count2 = 0
            numberPressed("4") }
        cinco.setOnClickListener { count = 0
            count2 = 0
            numberPressed("5") }
        seis.setOnClickListener { count = 0
            count2 = 0
            numberPressed("6") }
        siete.setOnClickListener { count = 0
            count2 = 0
            numberPressed("7") }
        ocho.setOnClickListener { count = 0
            count2 = 0
            numberPressed("8") }
        nueve.setOnClickListener { count = 0
            count2 = 0
            numberPressed("9") }
        cero.setOnClickListener { count = 0
            count2 = 0
            numberPressed("0")
        }
        count = 0
        punto.setOnClickListener {
            if(count2 == 0){
                numberPressed(".")
                count2++
            }
        }

        suma.setOnClickListener { count = 0
            count2 = 0
            operationPressed(Calculator.SUMA) }
        resta.setOnClickListener { count = 0
            count2 = 0
            operationPressed(Calculator.RESTA) }
        multiplicar.setOnClickListener {
            count = 0
            count2 = 0
            operationPressed(Calculator.MULTIPLICACION) }
        dividir.setOnClickListener {
            count++
            operationPressed(Calculator.DIVISION)
            if(count > 2){
                val intent: Intent = Intent(this, MainActivity()::class.java)
                startActivity(intent)
            }else{
                numberPressed("0")
            } }

        igual.setOnClickListener { resolvePressed() }

        etMsj = "Necesito de tú ayuda Por favor!!!, me encuentro en peligro"
        btnEnviar = findViewById(R.id.clearBtn)
        if (ActivityCompat.checkSelfPermission(
                this@Alerta,
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@Alerta,
                arrayOf(Manifest.permission.SEND_SMS),
                1
            )
        }
        btnEnviar.setOnClickListener {
            count++
            var codigo = "057"
            if (count > 2 ) {
                model.guardianes.observe(this, Observer { guardianes ->
                    for(x in guardianes){
                        if (etMsj == "") {
                            Toast.makeText(
                                this@Alerta,
                                "Ingrese el Mensaje y el Numero de Celular...",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            try {
                                val smsManager = SmsManager.getDefault()
                                smsManager.sendTextMessage(
                                    codigo+x.numero,
                                    null,
                                    etMsj,
                                    null,
                                    null
                                )
                                Toast.makeText(this@Alerta, "MSJ Enviado", Toast.LENGTH_LONG).show()
                            } catch (e: Exception) {
                                Toast.makeText(
                                    this@Alerta,
                                    "Error SMS...\n Ingrese un Numero Valido",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                })
                count = 0 // reset count
            }else{
                resetAll()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var etMsj: EditText? = null
        var etCel: EditText? = null
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val uri = data!!.data
            val cursor = contentResolver.query(uri!!, null, null, null, null)
            if (cursor != null && cursor.moveToFirst()) {
                val indiceName =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val indiceNumber =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val nombre = cursor.getString(indiceName)
                var numero = cursor.getString(indiceNumber)
                numero = numero.replace("(", "").replace(")", "").replace(" ", "").replace("-", "")
                etMsj!!.setText(nombre)
                etCel!!.setText(numero)
            }
        }
    }
    private fun numberPressed(num: String){
        val resultado = findViewById<TextView>(R.id.resultadoText)

        if(resultado.text == "0" && num != ".") {
            resultado.text = "$num"
        } else {
            resultado.text = "${resultado.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = resultado.text.toString().toDouble()
        } else {
            num2 = resultado.text.toString().toDouble()
        }
    }

    private fun operationPressed(operacion: Int){
        val resultado = findViewById<TextView>(R.id.resultadoText)

        this.operacion = operacion
        num1 = resultado.text.toString().toDouble()

        resultado.text = "0"
    }

    private fun resolvePressed(){
        val resultado = findViewById<TextView>(R.id.resultadoText)

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        resultado.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun resetAll(){
        val resultado = findViewById<TextView>(R.id.resultadoText)

        resultado.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
}