package edu.rockvalleycollege.apppreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtEmail = findViewById<EditText>(R.id.txtEmail) as EditText

        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        txtEmail.setText (preferences.getString ("mail", ""))
        val button1 = findViewById <Button>(R.id.btnSubmit) as Button

        button1.setOnClickListener {
            button1.setText("Email Saved")
            val editor = preferences.edit ()
            editor.putString ("mail", txtEmail.text.toString ())
            editor.commit ()

        }

        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}