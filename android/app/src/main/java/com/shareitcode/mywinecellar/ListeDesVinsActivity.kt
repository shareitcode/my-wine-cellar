package com.shareitcode.mywinecellar

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.shareitcode.mywinecellar.adapters.ListeDesVinsAdapter
import com.shareitcode.mywinecellar.database.MyWineCellarDb
import com.shareitcode.mywinecellar.entities.Vin
import kotlinx.android.synthetic.main.activity_liste_des_vins.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListeDesVinsActivity : AppCompatActivity(), ListeDesVinsAdapter.OnItemClickListener {

	private lateinit var db: MyWineCellarDb
	private var vins = ArrayList<Vin>()
	private val adapter = ListeDesVinsAdapter(vins, this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.activity_liste_des_vins)
		preparationDesDonnees()
		preparationComposantUtilisateur()
	}

	private fun preparationDesDonnees() {
		this.db = Room.databaseBuilder(applicationContext, MyWineCellarDb::class.java, "MyWineCellar").build()
		GlobalScope.launch {
			setLaListeDesVinsAvecLesDonneesEnBase()
		}
	}

	private fun setLaListeDesVinsAvecLesDonneesEnBase() {
		val vinsFromDatabase = db.vinDao().tousLesVins
		if (vinsFromDatabase.any()) for (vin in vinsFromDatabase) vins.add(vin)
	}

	private fun preparationComposantUtilisateur() {
		setRecyclerViewAvecLesVins()
		setClickListenerBoutonAjouterVin()
	}

	private fun setRecyclerViewAvecLesVins() {
		if (this.vins.any()) {
			this.recyclerView_vins.layoutManager = LinearLayoutManager(this.applicationContext)
			this.recyclerView_vins.adapter = ListeDesVinsAdapter(this.vins, this)
			this.recyclerView_vins.visibility = VISIBLE
			this.textView_aucun_vin_ajoute.visibility = GONE
		}
	}

	private fun setClickListenerBoutonAjouterVin() {
		this.button_ajouter_vin.setOnClickListener {
			val intentToAjouterUnVin = Intent(this, AjouterVinActivity::class.java)
			this.startActivity(intentToAjouterUnVin)
		}
	}

	override fun onItemClick(position: Int) {
		val vinSelectionne = vins[position]
		this.adapter.notifyItemChanged(position)
	}
}