package com.app.testformakepublish

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent: Intent? = null
        try {
            intent = Intent(this, Class.forName("com.gamesdk.MyGameActivity"))
            startActivity(intent)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
}