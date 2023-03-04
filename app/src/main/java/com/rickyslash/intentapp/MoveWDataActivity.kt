package com.rickyslash.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWDataActivity : AppCompatActivity() {

    // 'companion object' is an 'object associated' to 'this class'
    // often used to define 'properties/object' that 'doesn't require an instance' of class to be 'created'
    // So it 'could be called directly' by class name
    // ex: 'MoveWData.EXTRA_NAME' will return '"extra_name"'
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