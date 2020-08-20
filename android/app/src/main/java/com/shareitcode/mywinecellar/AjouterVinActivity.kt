package com.shareitcode.mywinecellar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_ajouter_vin.*

class AjouterVinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_vin)

        val spinnerCouleurDuVin: Spinner = this.spinner_couleur
        ArrayAdapter.createFromResource(this, R.array.vin_couleur, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCouleurDuVin.adapter = adapter
        }

        val spinnerMoyenAcquisition: Spinner = this.spinner_moyen_acquisition
        ArrayAdapter.createFromResource(this, R.array.moyen_acquisition, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMoyenAcquisition.adapter = adapter
        }
    }
}