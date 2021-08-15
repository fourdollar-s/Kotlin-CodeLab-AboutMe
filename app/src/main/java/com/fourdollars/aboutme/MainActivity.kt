package com.fourdollars.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get a reference to button, and attach the click listener to it
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }

        //get a reference to text view, and attach the click listener to it
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    //click listener for done button
    private fun addNickname(view: View){

        //get a reference to edit text and text view
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //set text in text view to text user entered
        nicknameTextView.text = editText.text

        //hide edit text
        editText.visibility = View.GONE
        //hide button
        view.visibility = View.GONE

        //make nickname text view visible
        nicknameTextView.visibility=View.VISIBLE

        //hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)

    }

    //click listener for text view
    private fun updateNickname (view: View){
        //get reference to views
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        //be visible or not
        editText.visibility=View.VISIBLE
        doneButton.visibility=View.VISIBLE
        view.visibility=View.GONE

        //set the focus to the edit text
        editText.requestFocus()

        //show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText,0)
    }
}