package com.example.aplikasimobileapppromo.data.remote

import com.example.aplikasimobileapppromo.Constants.Companion.PROMO_ENDPOINT
import com.example.aplikasimobileapppromo.data.remote.models.PromoModel
import retrofit2.Response
import retrofit2.http.GET

interface PromoApi {

    @GET(PROMO_ENDPOINT)
    suspend fun getPromos(): Response<List<PromoModel>>

}