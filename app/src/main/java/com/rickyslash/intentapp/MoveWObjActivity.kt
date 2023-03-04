package com.rickyslash.intentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWObjActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ROCKER = "extra_rocker"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_w_obj)

        val tvObjReceived: TextView = findViewById(R.id.tv_obj_received)

        val rocker = if (Build.VERSION.SDK_INT >= 33) {
            // 'parcelable' need 'companion object' and target'class'
            intent.getParcelableExtra(EXTRA_ROCKER, Rocker::class.java)
        } else {
            // '@Suppress' is an 'annotation' to give 'warnings' to 'compiler'
            // 'DEPRECATION' means the 'suppress' will 'raise' when using 'Deprecated API'
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Rocker>(EXTRA_ROCKER)
        }

        if (rocker != null) {
            val text = (
                    "Name\t\t\t\t\t : ${rocker?.name}\n" +
                    "Fav. Band\t\t : ${rocker?.band}\n" +
                    "Fav. Album\t : ${rocker?.album}\n" +
                    "Album Year\t : ${rocker?.year}"
                    )

            tvObjReceived.text = text
        }
    }
}