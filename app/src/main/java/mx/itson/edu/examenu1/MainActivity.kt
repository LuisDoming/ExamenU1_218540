package mx.itson.edu.examenu1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsius: TextView = findViewById(R.id.txCelsius)
        val kelvin: TextView = findViewById(R.id.txKelvin)
        val faren: TextView = findViewById(R.id.txFar)
        val btCelsius: Button = findViewById(R.id.btnCelsius)
        val btKelvin: Button = findViewById(R.id.btKelvin)
        val btFaren: Button = findViewById(R.id.btnFar)
        val btLimpiar: Button = findViewById(R.id.btnLimpiar)

        btLimpiar.setOnClickListener {
            faren.setText("")
            kelvin.setText("")
            celsius.setText("")
        }

        btKelvin.setOnClickListener{
            when{
                faren.text.isNotEmpty() ->{
                    faren.setText("")
                    kelvin.setText("")
                    celsius.setText("")
                }
                kelvin.text.isEmpty()->{
                    var resultado = celsiusAFAR(celsius.text.toString().toDouble())
                    faren.setText(resultado.toFloat().toString())
                    celsius.setText("")
                }
                celsius.text.isEmpty()->{
                    var resultado2 = kelvinAFAR(kelvin.text.toString().toDouble())
                    faren.setText(resultado2.toString())
                    kelvin.setText("")
                }
            }
        }

        btFaren.setOnClickListener{
            when{
                kelvin.text.isNotEmpty() -> {
                    kelvin.setText("")
                    celsius.setText("")
                    faren.setText("")
                }
                faren.text.isBlank()->{
                    var resultado = celsiusAKELVIN(celsius.text.toString().toDouble())
                    kelvin.setText(resultado.toFloat().toString())
                    celsius.setText("")
                }
                celsius.text.isEmpty()->{
                    var resultado2 = farAKELVIN(faren.text.toString().toDouble())
                    kelvin.setText(resultado2.toString())
                    faren.setText("")
                }
            }
        }

        btCelsius.setOnClickListener {
            when {
                celsius.text.isNotEmpty() ->{
                    celsius.setText("")
                    kelvin.setText("")
                    faren.setText("")
                }
                kelvin.text.isEmpty() -> {
                    var resultado = farACELSIUS(faren.text.toString().toDouble())
                    celsius.setText(resultado.toFloat().toString())
                    faren.setText("")
                }
                faren.text.isEmpty() -> {
                    var resultado2 = KelvinACELCIUS(kelvin.text.toString().toDouble())
                    celsius.setText(resultado2.toString())
                    kelvin.setText("")
                }
            }
        }
    }

    fun KelvinACELCIUS(kel:Double):Double{
        return kel - 273.15
    }

    fun celsiusAKELVIN(cel:Double):Double{
        return cel + 273.15
    }

    fun kelvinAFAR(kel:Double):Double{
        return (9*kel)-273.15 / 5 + 32
    }

    fun farAKELVIN(far:Double):Double{
        return (5*far)-32 / 9 + 273.15
    }

    fun farACELSIUS(far:Double):Double{
        return (far-32)/1.8
    }

    fun celsiusAFAR(cel:Double):Double{
        return (cel*1.8)+32
    }
}