package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Activity1 : AppCompatActivity() {

    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        Log.i("ciclo-vida","onCreate")
        val botonCicloVida = findViewById<Button>(
            R.id.btn_ciclo_vida
        )
        botonCicloVida.setOnClickListener{aumentarNumero();actualizarNumeroEnPantalla()}
    }

    fun aumentarNumero(){
        numero = numero + 1
    }

    fun actualizarNumeroEnPantalla(){
        val textViewCicloVida = findViewById<TextView>(
            R.id.txv_ciclo_vida
        )
        textViewCicloVida.text = numero.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run{
            //Aqui guardamos
            //Cualquier primitivo-Solo Primitivos
            putInt("numeroGuardado",numero)
        }
        super.onSaveInstanceState(outState)
        Log.i("ciclo-vida","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val numeroRecuperado1: Int? = savedInstanceState.getInt("numeroGuardado")
        if(numeroRecuperado1 != null){
            Log.i("ciclo-vida","Llego numero${numeroRecuperado1}")
            //this.numero = numero
            numero = numeroRecuperado1
            actualizarNumeroEnPantalla()
        }
        Log.i("ciclo-vida"," onRestoreInstanceState")
    }
    override fun onStart(){
        super.onStart()
        Log.i("ciclo-vida","OonStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida","onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida","onDestroy")
    }


}