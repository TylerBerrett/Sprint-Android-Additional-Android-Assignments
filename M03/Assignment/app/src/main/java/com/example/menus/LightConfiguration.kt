package com.example.menus

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_light_configuration.*

class LightConfiguration : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_configuration)

        title = "Light Configuration"

        display_name.text = "Light Configuration"
    }
}
