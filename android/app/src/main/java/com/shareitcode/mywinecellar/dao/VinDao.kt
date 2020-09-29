package com.shareitcode.mywinecellar.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shareitcode.mywinecellar.entities.Vin

@Dao
interface VinDao {

    @get:Query("SELECT * FROM vin")
    val tousLesVins : Array<Vin>

    @Insert
    fun ajouterUnVin(vin: Vin)
}