package com.ahmetmb.weightonotherplanets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

/*
    Ahmet Mucahid Bozkurt - github.com/amucahidbozkurt
 */

class MainActivity : AppCompatActivity() {

    val KILO_TO_POUND = 2.2046
    val POUND_TO_KILO = 0.45359237
    val VENUS = 0.91
    val NEPTUNE = 1.19
    val SATURN = 1.06
    val MERCURY = 0.38

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userWeight = enterWeight.text

        val textViews : List<TextView> = listOf(venusText, neptuneText, saturnText, mercuryText)
        val planetGravity : List<Double> = listOf(VENUS, NEPTUNE, SATURN, MERCURY)

        calculateButton.setOnClickListener {

            var userCalculatePound = kgToPound(userWeight.toString().toDouble())

            textViews.forEachIndexed { index, textView ->
                textView.text = poToKilo(userCalculatePound * planetGravity[index]).
                    formatShort(2).toString() + "kg"
            }

        }
    }

    fun kgToPound(kilo: Double) : Double {

        return kilo * KILO_TO_POUND
    }

    fun poToKilo(pound: Double) : Double {

        return pound * POUND_TO_KILO
    }

    fun Double.formatShort(showNumber: Int) = java.lang.String.format("%.${showNumber}f", this)

}
