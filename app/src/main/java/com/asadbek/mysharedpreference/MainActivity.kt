package com.asadbek.mysharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.asadbek.mysharedpreference.databinding.ActivityMainBinding
import com.asadbek.mysharedpreference.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreference.init(this)
        binding.txt1.text = MySharedPreference.name

        binding.edt1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MySharedPreference.name = binding.edt1.text.toString()
                binding.txt1.text = MySharedPreference.name
            }

            override fun afterTextChanged(s: Editable?) {
                MySharedPreference.name = binding.edt1.text.toString()
                binding.txt1.text = MySharedPreference.name
            }
        })
    }
}