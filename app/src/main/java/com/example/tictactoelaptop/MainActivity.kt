package com.example.tictactoelaptop

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button_pvp)
        btn.setOnClickListener {
            val versusIntent = Intent(this, VersusPlayer::class.java)
            startActivity(versusIntent)
        }
    }
}
