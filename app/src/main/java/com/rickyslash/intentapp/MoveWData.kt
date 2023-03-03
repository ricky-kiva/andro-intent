package com.rickyslash.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWData : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_UNIV = "extra_univ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_w_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // '.getStringExtra' will get 'string' that is passed from 'putExtra'
        val name = intent.getStringExtra(EXTRA_NAME)
        val univ = intent.getStringExtra(EXTRA_UNIV)

        val text = "$name from $univ"
        tvDataReceived.text = text
    }
}