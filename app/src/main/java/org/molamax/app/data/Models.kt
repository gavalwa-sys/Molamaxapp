package org.molamax.app.data

data class ProductCategory(
    val slug: String,
    val name: String,
    val emoji: String,
    val description: String
)

data class Product(
    val slug: String,
    val name: String,
    val categorySlug: String,
    val categoryName: String,
    val tagline: String,
    val description: String,
    val suitableFor: List<String>,
    val highlights: List<String>
)

data class Article(
    val slug: String,
    val category: String,
    val title: String,
    val excerpt: String
)

data class Faq(
    val category: String,
    val question: String,
    val answer: String
)

data class Stockist(
    val name: String,
    val country: String,
    val town: String,
    val phone: String
)
