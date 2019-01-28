package com.example.motivation.kotlin_calculator

import android.util.Log

fun isOperator(operator: String): Boolean {

    if (operator.toIntOrNull() == null) {
        Log.d("isOperator", operator)
        return true
    }
    return false
}

fun getLastElemnet(exprArrayList: ArrayList<String>): String{
    return exprArrayList[exprArrayList.lastIndex]
}