package com.app.testformakepublish

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//        supportFragmentManager.beginTransaction().replace(R.id.fragmentOne, MyGame(), "dynamic_fragment")

        /*val fragment = Class.forName("com.gamesdk.MyGame").newInstance()
        if (fragment is Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentOne, fragment, "dynamic_fragment")
                .addToBackStack("dynamic_fragment")
                .commit()
        }*/

        var intent: Intent? = null
        try {
            intent = Intent(this, Class.forName("com.gamesdk.MyGameActivity"))
            startActivity(intent)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
}