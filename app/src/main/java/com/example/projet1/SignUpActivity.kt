package com.example.projet1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_in_button.setOnClickListener {
            Data.useremail = findViewById<TextView>(R.id.editText).text.toString()
            Data.username = findViewById<TextView>(R.id.editText2).text.toString()
            Data.userphone = findViewById<TextView>(R.id.editText3).text.toString()
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}
