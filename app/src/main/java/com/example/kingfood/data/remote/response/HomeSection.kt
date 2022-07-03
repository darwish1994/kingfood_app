package com.example.kingfood.data.remote.response

import com.example.kingfood.domain.model.Offer
import com.example.kingfood.domain.model.Section

data class HomeSection(
    val section: List<Section>,
    val offer: List<Offer>,
)
