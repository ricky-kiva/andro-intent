package com.rickyslash.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add button to move to 'Move Activity'
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener {
            when(it?.id) {
                R.id.btn_move_activity -> {
                    // initializing Intent object from 'context' (this@MainActivity) to 'destination activity' (MoveActivity)(explicit intent)
                    // '@' used to label the 'this' so it's not disambiguated
                    // 'context' is a 'class' to access 'resource' in targeted 'activity'
                    // '::' commonly used for passing class objects as parameter. Used to reference 'java' class object of the 'MoveActivity' class
                    val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)

                    // 'startActivity' will run an activity 'without carrying data'
                    startActivity(moveIntent)
                }
            }
        }
    }
}