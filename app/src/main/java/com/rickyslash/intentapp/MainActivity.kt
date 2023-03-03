package com.rickyslash.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

/* INTENT THEORY */

// 'Intent' is an 'action' to 'communicate between component' such: Activity, Service, & Broadcast Receiver

// 3 common usage of intent:
// - 'Switching activity' from one to another
// - Run background service. ex: synchronize to server / doing scheduled task
// - 'Send broadcast object' to requesting app. ex: an app need to get broadcast object from Android system for booting event

// 2 'forms' of 'Intent':
// - Explicit Intent: An intent that is clear (explicit), like moving to another activity
// - Implicit Intent: An intent that doesn't need details of class name, to use a function from another app, like using Camera app / get image from Gallery app

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add button to move to 'Move Activity'
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWData: Button = findViewById(R.id.btn_move_w_data)

        // add listener for buttons
        btnMoveActivity.setOnClickListener(this)
        btnMoveWData.setOnClickListener(this)

    }

    // make 'onClick' function for button
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                // initializing Intent object from 'context' (this@MainActivity) to 'destination activity' (MoveActivity)(explicit intent)
                // '@' used to label the 'this' so it's not disambiguated
                // 'context' is a 'class' to access 'resource' in 'targeted activity'
                // '::' commonly used for passing class objects as parameter. Used to reference 'java' class object of the 'MoveActivity' class
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)

                // 'startActivity' will run the Intent
                startActivity(moveIntent)
            }

            R.id.btn_move_w_data -> {
                val moveWDataIntent = Intent(this@MainActivity, MoveWData::class.java)

                // 'putExtra' will 'send' data along with 'Intent object' to 'targeted activity'
                // 'putExtra' carry a 'key-value' format data
                moveWDataIntent.putExtra(MoveWData.EXTRA_NAME, "Rickyslash")
                moveWDataIntent.putExtra(MoveWData.EXTRA_UNIV, "Universitas Gadjah Mada")

                startActivity(moveWDataIntent)
            }
        }
    }
}