package com.rickyslash.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener {
            when(it?.id) {
                R.id.btn_move_activity -> {
                    val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                    startActivity(moveIntent)
                }
            }
        }
    }
}