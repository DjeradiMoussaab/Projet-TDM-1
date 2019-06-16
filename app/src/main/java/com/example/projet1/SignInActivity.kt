package com.example.projet1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        inscrire.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        sign_in_button.setOnClickListener {
            if (Data.useremail != "") {
                startActivity(Intent(this, NavigationActivity::class.java))
            }
        }
    }
}
