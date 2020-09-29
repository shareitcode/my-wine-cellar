package com.shareitcode.mywinecellar.models

import java.util.*

class Vin {
    var producteur: String = ""
    var pays: String = ""
    var region: String = ""
    var appellation: String = ""
    var parcelle: String = ""
    var millesime: Int = 0
    var quantite: Int = 0
    var couleur: String = ""
    var prix: Double = 0.0
    var dateAcquisition: Date = Date()
    var moyenAcquisition: String = ""
}