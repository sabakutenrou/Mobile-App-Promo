package com.example.aplikasimobileapppromo.data.remote

import com.example.aplikasimobileapppromo.data.remote.models.PromoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PromoService @Inject constructor(private val promoApi: PromoApi) {

    suspend fun getPromo(): List<PromoModel> {
        return withContext(Dispatchers.IO) {
            val promos = promoApi.getPromos()
            promos.body()?: emptyList()
        }
    }


}