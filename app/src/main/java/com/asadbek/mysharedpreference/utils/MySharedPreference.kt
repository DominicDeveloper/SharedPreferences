package com.asadbek.mysharedpreference.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "my_cache" // kesh nomi
    private const val MODE = Context.MODE_PRIVATE // keshga yozish turi
    private lateinit var sharedPreferences: SharedPreferences // sharedpreferences

    fun init(context: Context){ // instlz...
        sharedPreferences = context.getSharedPreferences(NAME, MODE)

    }
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor)-> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    var name :String?
    get() = sharedPreferences.getString("kalit","empty") // keshdagi malumotni olish
    set(value) = sharedPreferences.edit { // keshga malumotni yozish
        it.putString("kalit",value)
    }
}