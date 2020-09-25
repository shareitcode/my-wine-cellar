package com.shareitcode.mywinecellar

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shareitcode.mywinecellar.databinding.ActivityAjouterVinBinding
import kotlinx.android.synthetic.main.activity_ajouter_vin.*

class AjouterVinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAjouterVinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ajouter_vin)

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

        this.button_ajouter.setOnClickListener {
            Log.d("", binding.editTextProducteur.text.toString())
        }
    }
}