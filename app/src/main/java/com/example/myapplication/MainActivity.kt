package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var clickCount = 0
    var usersList: MutableMap<String, Int> = mutableMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDispayViews = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)

        clickMeButton.setOnClickListener {
            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName
            if (userName in usersList.keys) {

                clickCount = usersList[userName]!!
                clickCount++
                usersList[userName!!] = clickCount
            } else {
                clickCount = 1
                usersList[userName!!] = clickCount
            }
            clickCountDispayViews.text = "$maskedUserName clicked $clickCount times"

        }
    }
}