package com.example.projet1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var myanim : Animation = AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation)
        logo_splash.startAnimation(myanim)

        myanim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {

                startActivity(Intent(this@SplashScreenActivity, SignInActivity::class.java))
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
    }
}
