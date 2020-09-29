package com.shareitcode.mywinecellar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shareitcode.mywinecellar.database.MyWineCellarDb
import com.shareitcode.mywinecellar.databinding.ActivityAjouterVinBinding
import com.shareitcode.mywinecellar.entities.Vin
import kotlinx.android.synthetic.main.activity_ajouter_vin.*

class AjouterVinActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var db: MyWineCellarDb
    private lateinit var binding: ActivityAjouterVinBinding
    private lateinit var couleurVin: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ajouter_vin)

        setSpinnerCouleurDuVin()
        setSpinnerMoyenAcquisition()
        setListennerOnBoutonAjouter()
    }

    private fun setSpinnerCouleurDuVin() {
        val spinnerCouleurDuVin: Spinner = this.spinner_couleur
        ArrayAdapter.createFromResource(
            this, R.array.vin_couleur, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCouleurDuVin.adapter = adapter
            spinnerCouleurDuVin.onItemSelectedListener = this
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (view?.id == this.spinner_couleur.id) {
            this.couleurVin = parent?.getItemAtPosition(position).toString()
        }
        if (view?.id == this.spinner_moyen_acquisition.id) {
            this.couleurVin = parent?.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun setSpinnerMoyenAcquisition() {
        val spinnerMoyenAcquisition: Spinner = this.spinner_moyen_acquisition
        ArrayAdapter.createFromResource(
            this, R.array.moyen_acquisition, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMoyenAcquisition.adapter = adapter
            spinnerMoyenAcquisition.onItemSelectedListener = this
        }
    }

    private fun setListennerOnBoutonAjouter() {
        this.button_ajouter.setOnClickListener {
            Log.d("", binding.editTextProducteur.text.toString())
            val vin = Vin(
                null,
                binding.editTextProducteur.text.toString(),
                binding.editTextPays.text.toString(),
                binding.editTextRegion.text.toString(),
                binding.editTextAppellation.text.toString(),
                binding.editTextParcelle.text.toString(),
                binding.editTextMillesime.text.toString().toInt(),
                binding.editTextQuantite.text.toString().toInt(),
                this.couleurVin,
                binding.editTextPrix.text.toString().toDouble(),
                this.couleurVin
            )
            this.db.vinDao().ajouterUnVin(vin)
        }
    }
}