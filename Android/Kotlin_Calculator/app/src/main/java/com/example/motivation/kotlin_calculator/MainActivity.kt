package com.example.motivation.kotlin_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var exprArrayList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_reset.setOnClickListener {
            outputText.setText("0")
            exprArrayList.clear()
        }

        btn_result.setOnClickListener {
            getResult()
        }

        btn_reverse.setOnClickListener {

        }
    }

    fun numOnClick(text: View) {
        val numText = text as TextView
        val  num = numText.text.toString()

        if (exprArrayList.size == 0 && num == "0") {
            outputText.setText("0")
            return
        } else if (exprArrayList.size == 0)
            outputText.setText(num)
        else
            outputText.append(num)

        exprArrayList.add(num)
    }

    fun onCalculateClick(opt: View) {
        var operatorTextView = opt as TextView
        var operator = operatorTextView.text.toString()

        exprArrayList.add(operator)
    }

    fun getResult() {
        Log.d("Expr", exprArrayList.toString())
    }

}
