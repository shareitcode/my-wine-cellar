package com.shareitcode.mywinecellar

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
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
		this.setLaListeDesVinsAvecLesDonneesEnBase()
		this.vins = generateMockData()
	}

	private fun setLaListeDesVinsAvecLesDonneesEnBase() {
		GlobalScope.launch {
			val vinsFromDatabase = db.tousLesVinsDao().tousLesVins
			if (vinsFromDatabase.any()) {
				for (vin in vinsFromDatabase) {
					vins.add(vin)
				}
			}
		}
	}

	private fun generateMockData(): ArrayList<Vin> {
		val vins = ArrayList<Vin>()
		val vinUn = Vin(1, "", "", "", "Vin un", "", 2020, 1, "", 10.0, "")
		val vinDeux = Vin(2, "", "", "", "Vin deux", "", 2020, 1, "", 10.0, "")
		val vinTrois = Vin(3, "", "", "", "Vin trois", "", 2020, 1, "", 10.0, "")
		vins.add(vinUn)
		vins.add(vinDeux)
		vins.add(vinTrois)
		return vins
	}

	private fun preparationComposantUtilisateur() {
		setRecyclerViewAvecLesVins()
		setClickListenerBoutonAjouterVin()
	}

	private fun setRecyclerViewAvecLesVins() {
		if (this.vins.any()) {
			this.recyclerView_vins.layoutManager = LinearLayoutManager(this.applicationContext)
			this.recyclerView_vins.itemAnimator = DefaultItemAnimator()
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