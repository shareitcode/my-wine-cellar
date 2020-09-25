package com.shareitcode.mywinecellar.models

import java.util.*

data class Vin(
    var producteur: String,
    var pays: String,
    var region: String,
    var appellation: String,
    var parcelle: String,
    var millesime: Int,
    var quantite: Int,
    var couleur: String,
    var prix: Double,
    var dateAcquisition: Date,
    var moyenAcquisition: String
)