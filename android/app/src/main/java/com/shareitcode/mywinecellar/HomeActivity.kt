package com.shareitcode.mywinecellar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.button_ajouter_vin.setOnClickListener { view ->
            val intentToAjouterUnVin: Intent = Intent(this, AjouterVinActivity::class.java);
            this.startActivity(intentToAjouterUnVin)
        }
    }
}