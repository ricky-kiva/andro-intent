package com.rickyslash.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity() {

    private lateinit var btnChoose: Button
    private lateinit var rgAlbum: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VAL = "extra_selected_val"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgAlbum = findViewById(R.id.rg_album)

        btnChoose.setOnClickListener {
            var album: String? = null
            if (it.id == R.id.btn_choose) {
                if (rgAlbum.checkedRadioButtonId > 0) {
                    when (rgAlbum.checkedRadioButtonId) {
                        R.id.rb_TDSOTM -> album = "The Dark Side of the Moon"
                        R.id.rb_TW -> album = "The Wall"
                        R.id.rb_AHM -> album = "Atom Heart Mother"
                        R.id.rb_TFC -> album = "The Final Cut"
                    }
                }
            }

            val result = intent.putExtra(EXTRA_SELECTED_VAL, album)
            setResult(RESULT_CODE, result)

            // 'finish()' will close the 'this' activity (MoveForResultActivity) & back to activity before
            finish()
        }
    }
}