package com.example.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros = 1
    var player1 = 0
    var player2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i( "idjwa",  "log")
        tirar()
    }
    fun tirar(){

        roll_dice.setOnClickListener {
            tiros++
                val rand = Random.nextInt(1, 6)
                score.text = "You got a $rand"
                if (tiros %2 !=0 ) {
                    player1 +=rand
                    roll_dice.text = "Player 2 roll"
                }
                else {
                    roll_dice.text = "Player 1 roll"
                    player2 += rand
                }
            if (tiros> 6) {
                if (player1 > player2){
                    score.text= "Player 1 wins with  $player1 points"
                }
                else {
                    score.text= "Player 2 wins with  $player2 points"
                }
                roll_dice.text = "New game!"
                roll_dice.setOnClickListener {
                    player1 = 0
                    player2 = 0
                    tiros = 1
                    tirar()
                    roll_dice.text = "Player 1 Roll"
                    score.text= "Get ready!"
                }
            }
                }






    }
}