package com.example.aplikasimobileapppromo.domain.items

import com.example.aplikasimobileapppromo.data.remote.models.Img
import com.example.aplikasimobileapppromo.data.remote.models.PromoModel

data class PromoItem(
    val id: Int,
    val nama: String,
    val desc: String,
    val lokasi: String,
    val createdAt: String,
    val created_at: String,
    val published_at: String,
    val updated_at: String,
    val img: Img
)

fun PromoModel.toPromoItem() = PromoItem(id, nama, desc, lokasi, createdAt, created_at, published_at, updated_at, img)
