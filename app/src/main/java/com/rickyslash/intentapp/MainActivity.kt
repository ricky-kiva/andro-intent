package com.rickyslash.intentapp

import android.content.Intent
import android.net.Uri
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
        val btnMoveWObj: Button = findViewById(R.id.btn_move_w_object)
        val btnDialActivity: Button = findViewById(R.id.btn_dial)

        // add listener for buttons
        btnMoveActivity.setOnClickListener(this)
        btnMoveWData.setOnClickListener(this)
        btnMoveWObj.setOnClickListener(this)
        btnDialActivity.setOnClickListener(this)

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
                val moveWDataActivityIntent = Intent(this@MainActivity, MoveWDataActivity::class.java)

                // 'putExtra' will 'send' data along with 'Intent object' to 'targeted activity'
                // 'putExtra' carry a 'key-value' format data
                moveWDataActivityIntent.putExtra(MoveWDataActivity.EXTRA_NAME, "Rickyslash")
                moveWDataActivityIntent.putExtra(MoveWDataActivity.EXTRA_UNIV, "Universitas Gadjah Mada")

                startActivity(moveWDataActivityIntent)
            }

            R.id.btn_move_w_object -> {
                val moveWObjActivityIntent = Intent(this@MainActivity, MoveWObjActivity::class.java)

                // making new Rocker 'object' to be parsed by Parcelable
                val rocker = Rocker("Rickyslash", "Pink Floyd", 1973, "The Dark Side of the Moon")

                moveWObjActivityIntent.putExtra(MoveWObjActivity.EXTRA_ROCKER, rocker)

                startActivity(moveWObjActivityIntent)
            }

            R.id.btn_dial -> {
                val phoneNumber = "+62-274-580882"
                // 'Implicit Intent' need 'Action' & 'Uri' to be initialized
                // 'Uri' (Uniform Resource Identifier) is a characters that identify a name, source, or service in the internet
                // 'Uri' is based on 'RFC 2396'
                // 'tel:' is the schema 'phoneNumber' is the text

                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialIntent)
            }
        }
    }
}