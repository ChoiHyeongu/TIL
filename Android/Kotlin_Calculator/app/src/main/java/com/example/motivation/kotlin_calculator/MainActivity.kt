package com.example.motivation.kotlin_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import kotlin.math.exp


class MainActivity : AppCompatActivity() {

    var mgr = ScriptEngineManager()
    var engine = mgr.getEngineByName("js")

    var isOperator = false
    var isResult = false
    var exprArrayList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_reset.setOnClickListener {
            isResult = false
            exprArrayList.clear()
            outputText.setText("0")
        }

        btn_result.setOnClickListener {
            if (isResult == false)
                getResult(exprArrayList)
        }

        btn_reverse.setOnClickListener {
            isResult = false
        }
    }

    fun numOnClick(text: View) {
        isResult = false
        val textView = text as TextView
        var value = textView.text.toString()

        if (isOperator == true) {
            outputText.setText(value)
            isOperator = false
        } else if (outputText.text.toString() == "0")
            outputText.setText(value)
        else
            outputText.append(value)
    }

    fun onCalculateClick(opt: View) {
        isResult = false
        val textView = opt as TextView
        val operator = textView.text.toString()
        isOperator = true

        exprArrayList.add(outputText.text.toString())
        exprArrayList.add(operator)

        Log.d("fun: onCalculate: ", operator.toString())
    }

    fun getResult(expr: ArrayList<String>) {
        isOperator = true
        isResult = true
        exprArrayList.add(outputText.text.toString())
        var expression = ""


        for(item in expr)
            expression += item

        var result = engine.eval(expression)
        outputText.setText(result.toString())
        Log.d("fun: getResult", expression)
    }
}
