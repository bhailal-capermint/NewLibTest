package com.gamesdk
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_game.*


public class MyGameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        var gameList = ArrayList<Result>()

        gameList.add(Result(1, R.drawable.ic_dart, "Darts","http://staging-server.in/HTML_Games_Tijara/darts/"))
        gameList.add(Result(2, R.drawable.ic_disk_rush, "Disk Rush","http://staging-server.in/HTML_Games_Tijara/disk-rush/"))
        gameList.add(Result(3, R.drawable.ic_hyper_hocky, "Hyper Hockey","http://staging-server.in/HTML_Games_Tijara/hyper-hockey/"))
        gameList.add(Result(4, R.drawable.ic_marvel_bird, "Marvel Bird","http://staging-server.in/HTML_Games_Tijara/marvel-bird/"))
        gameList.add(Result(5, R.drawable.ic_tic_tac_toe, "Tic Tac Toe","http://staging-server.in/HTML_Games_Tijara/tic-tac-toe/"))

        var gridLayoutManager= GridLayoutManager(this, 3)
        recyclerViewGame.layoutManager = gridLayoutManager
        var gameGridAdapter = GameListAdapter(
            gameList
        ) { position, game, v ->
            val myIntent = Intent(this@MyGameActivity, WebViewGameActivity::class.java)
            myIntent.putExtra("gameData", game) //Optional parameters
            startActivity(myIntent)
        }
        recyclerViewGame.adapter = gameGridAdapter

    }


}

