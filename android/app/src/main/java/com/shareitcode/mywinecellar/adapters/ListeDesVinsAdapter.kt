package com.shareitcode.mywinecellar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shareitcode.mywinecellar.R
import com.shareitcode.mywinecellar.entities.Vin

internal class ListeDesVinsAdapter(private val vins: ArrayList<Vin>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ListeDesVinsAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_liste_vins, parent, false)
        )
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val res = holder.itemView.context.resources
		holder.appellation.text = this.vins[position].appellationVin
		holder.millesime.text = this.vins[position].millesimeVin.toString()
		holder.quantite.text = this.vins[position].quantiteVin.toString()
	}

	override fun getItemCount() = this.vins.size

	inner class ViewHolder(vinItemView: View) : RecyclerView.ViewHolder(vinItemView), View.OnClickListener {
		val appellation: TextView = itemView.findViewById(R.id.textView_vin_appellation)
		val millesime: TextView = itemView.findViewById(R.id.textView_vin_millesime)
		val quantite: TextView = itemView.findViewById(R.id.textView_vin_quantite)

		init {
			vinItemView.setOnClickListener(this)
		}

		override fun onClick(v: View?) {
			val position = adapterPosition
			if (position != RecyclerView.NO_POSITION) {
				listener.onItemClick(position)
			}
		}
	}

	interface OnItemClickListener {
		fun onItemClick(position: Int)
	}
}