package com.trydev.cbr.model

data class Similarity(
    var history: History,
    var listIndicationSimilarityValue: ArrayList<IndicationSimilarityValue>,
    var result: Double
)