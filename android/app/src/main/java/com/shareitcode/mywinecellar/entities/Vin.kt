package com.shareitcode.mywinecellar.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "vin", indices = [Index(value = ["producteur_vin", "pays_vin", "region_vin", "appellation_vin", "parcelle_vin"])])
data class Vin (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_vin")
    val idVin: Long?,

    @ColumnInfo(name = "producteur_vin")
    val producteurVin: String,

    @ColumnInfo(name = "pays_vin")
    val paysVin: String,

    @ColumnInfo(name = "region_vin")
    val regionVin: String,

    @ColumnInfo(name = "appellation_vin")
    var appellationVin: String,

    @ColumnInfo(name = "parcelle_vin")
    val parcelleVin: String,

    @ColumnInfo(name = "millesime_vin")
    val millesimeVin: Int,

    @ColumnInfo(name = "quantite_vin")
    val quantiteVin: Int,

    @ColumnInfo(name = "couleur_vin")
    val couleurVin: String,

    @ColumnInfo(name = "prix_vin")
    val prixVin: Double,

// TODO: develop date converter for Room entity
//  @ColumnInfo(name = "dateAcquisition_vin")
//  val dateAcquisition: Date,

    @ColumnInfo(name = "moyenAcquisition_vin")
    val moyenAcquisition: String
)