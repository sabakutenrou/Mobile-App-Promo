package com.example.aplikasimobileapppromo.domain

import com.example.aplikasimobileapppromo.domain.items.PromoItem
import com.example.aplikasimobileapppromo.repo.PromoRepository
import javax.inject.Inject

class GetPromosUseCase @Inject constructor(private val promoRepository: PromoRepository) {
    suspend operator fun invoke(): List<PromoItem> {
        return promoRepository.getPromos()
    }
}