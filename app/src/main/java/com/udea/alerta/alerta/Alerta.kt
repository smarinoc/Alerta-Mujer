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
import com.udea.alerta.R
import com.udea.alerta.calculator.Calculator
import com.udea.alerta.ui.MainActivity
import java.lang.Exception

class Alerta : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        var etMsj: String? = null
        var etCel: String? = null
        var btnEnviar: Button? = null
        var count = 0
        val resultado = findViewById<TextView>(R.id.resultadoText)

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

        uno.setOnClickListener { numberPressed("1") }
        dos.setOnClickListener { numberPressed("2") }
        tres.setOnClickListener { numberPressed("3") }
        cuatro.setOnClickListener { numberPressed("4") }
        cinco.setOnClickListener { numberPressed("5") }
        seis.setOnClickListener { numberPressed("6") }
        siete.setOnClickListener { numberPressed("7") }
        ocho.setOnClickListener { numberPressed("8") }
        nueve.setOnClickListener { numberPressed("9") }
        cero.setOnClickListener { numberPressed("0")
            val intent: Intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }
        punto.setOnClickListener { numberPressed(".") }

        clear.setOnClickListener { resetAll() }

        suma.setOnClickListener { operationPressed(Calculator.SUMA) }
        resta.setOnClickListener { operationPressed(Calculator.RESTA) }
        multiplicar.setOnClickListener { operationPressed(Calculator.MULTIPLICACION) }
        dividir.setOnClickListener { operationPressed(Calculator.DIVISION) }

        igual.setOnClickListener { resolvePressed() }

        etMsj = "entonces que bien o no"
        etCel = "0573103629019"
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
            if (count > 2 ) {
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
                            etCel,
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


                if (etCel == "") {
                    try {
                        val sendIntent = Intent()
                        sendIntent.action = Intent.ACTION_SEND
                        sendIntent.putExtra(Intent.EXTRA_TEXT, etMsj)
                        sendIntent.type = "text/plain"
                        sendIntent.setPackage("com.whatsapp")
                        startActivity(sendIntent)
                    } catch (e: Exception) {
                        Toast.makeText(
                            this@Alerta,
                            "Error de Whatsapp.\nInstale la App",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    try {
                        val sendIntent = Intent()
                        sendIntent.action = Intent.ACTION_VIEW
                        val uri = "whatsapp://send?phone=" + etCel
                            .toString() + "&text=" + etMsj
                        sendIntent.data = Uri.parse(uri)
                        startActivity(sendIntent)
                    } catch (e: Exception) {
                        Toast.makeText(
                            this@Alerta,
                            "Error de Whatsapp.\nInstale la App",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                count = 0 // reset count
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