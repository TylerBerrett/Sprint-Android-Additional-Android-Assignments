package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_controller_configuration.*

class ControllerConfiguration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controller_configuration)

        title = "Controller Configuration"

        display_name.text = "Controller Configuration"
    }
}
