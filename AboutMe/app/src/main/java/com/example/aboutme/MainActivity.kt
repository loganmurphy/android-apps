package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("LDAWG2k")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.apply {
            doneButton.setOnClickListener { addNickName(it) }
            nicknameText.setOnClickListener { updateNickname(it) }
        }
    }

    private fun addNickName(view: View) {
        view.visibility = View.GONE

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

        }


        // hide the keyboard
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        view.visibility = View.GONE

        binding.apply {
            doneButton.visibility = View.VISIBLE
            nicknameEdit.visibility = View.VISIBLE
            nicknameEdit.requestFocus()
        }

        // show the keyboard
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.nicknameEdit, 0)
    }
}
