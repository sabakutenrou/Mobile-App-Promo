package com.example.aplikasimobileapppromo.repo

import com.example.aplikasimobileapppromo.data.remote.PromoService
import com.example.aplikasimobileapppromo.domain.items.PromoItem
import com.example.aplikasimobileapppromo.domain.items.toPromoItem
import javax.inject.Inject

class PromoRepository @Inject constructor(private val promoService: PromoService) {
    suspend fun getPromos(): List<PromoItem> {
        return promoService.getPromo().map {
            it.toPromoItem()
        }
    }
}