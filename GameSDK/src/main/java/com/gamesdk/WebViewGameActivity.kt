package com.gamesdk

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebSettings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_webview_game.*

class WebViewGameActivity : AppCompatActivity() {

    private var mData : Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_game)

        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
        val extras = intent.extras
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true)
        }

        mData = intent.getParcelableExtra("gameData")

       /* if (mData?.gameOrientation.equals(AppConstant.GAME_ORIENTATION_LANDSCAPE)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;

        }else if (mData?.gameOrientation.equals(AppConstant.GAME_ORIENTATION_PORTRAIT)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;
        }*/

        webView.loadUrl(mData?.gameUrl)
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        showGameExitDialog()
    }

    private fun showGameExitDialog(){
        var view = LayoutInflater.from(this).inflate(R.layout.game_exit_dialog, null)
        var alertDialogBuilder : AlertDialog.Builder = getCustomAlertDialog(view)
        var alertDialog = alertDialogBuilder.create()

        var btnNo = view.findViewById<AppCompatButton>(R.id.btnNo)
        var btnYes = view.findViewById<AppCompatButton>(R.id.btnYes)

        btnNo?.setOnClickListener {
            alertDialog.dismiss()
        }

        btnYes?.setOnClickListener {
            alertDialog.dismiss()
            finish()
        }
        alertDialog.show()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun Activity.getCustomAlertDialog(view: View) : AlertDialog.Builder{
        val builder =
            AlertDialog.Builder(this)
        builder.setView(view)
        builder.setCancelable(true)
        return builder
    }
}