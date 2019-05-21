package com.example.tictactoelaptop

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class VersusPlayer : AppCompatActivity() {
    private var game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_versus_player)
        //create onClickListeners for the buttons that make up the board
        val buttons = arrayOf(findViewById<Button>(R.id.button_1), findViewById(R.id.button_2), findViewById(R.id.button_3),
            findViewById(R.id.button_4), findViewById(R.id.button_5), findViewById(R.id.button_6),
            findViewById(R.id.button_7), findViewById(R.id.button_8), findViewById(R.id.button_9))
        for(btn in buttons) {
            btn.setOnClickListener {
                val tag = btn.tag as String
                val out = play(tag)
                btn.text = out
            }
        }
        val resetBtn = findViewById<Button>(R.id.reset_button)
        resetBtn.setOnClickListener{
            resetBoard()
        }
    }


    fun play(position: String): String{
        val (state, text, win) = game.turn(position)
        //checks to see if there is a win state and output corresponding info based on who won or if draw
        if(state >= 1) endGame(state, win)
        return text
    }


    private fun resetBoard(){
        game = Game()
        val buttons = arrayOf(findViewById<Button>(R.id.button_1), findViewById(R.id.button_2), findViewById(R.id.button_3),
            findViewById(R.id.button_4), findViewById(R.id.button_5), findViewById(R.id.button_6),
            findViewById(R.id.button_7), findViewById(R.id.button_8), findViewById(R.id.button_9))
        for(btn in buttons){
            btn.text = " "
            btn.isEnabled = true
            btn.setTextColor(Color.BLACK)
        }
    }

    private fun endGame(state: Int, win: List<Int>){
        var toastMsg = "Draw"
        val toast: Toast
        if(state==1){
            toastMsg = "X wins!"
            val winTextView = findViewById<TextView>(R.id.xWins)
            var winString = winTextView.text.toString()
            val winNum = winString.substring(3)
            var wins = Integer.parseInt(winNum)
            wins++
            winString = "X: " + wins.toString()
            winTextView.text = winString
        }
        else if(state==2){
            toastMsg = "O wins!"
            val winTextView = findViewById<TextView>(R.id.oWins)
            var winString = winTextView.text.toString()
            val winNum = winString.substring(3)
            var wins = Integer.parseInt(winNum)
            wins++
            winString = "O: " + wins.toString()
            winTextView.text = winString
        }
        toast = Toast.makeText(this,toastMsg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
        //disable buttons anf if there are values in win make the corresponding buttons green
        val buttons = arrayOf(findViewById<Button>(R.id.button_1), findViewById(R.id.button_2), findViewById(R.id.button_3),
            findViewById(R.id.button_4), findViewById(R.id.button_5), findViewById(R.id.button_6),
            findViewById(R.id.button_7), findViewById(R.id.button_8), findViewById(R.id.button_9))
        for(btn in buttons){
            btn.isEnabled = false
        }
        for(w in win){
            val btn = buttons[w]
            btn.setTextColor(Color.GREEN)
        }
    }
}
