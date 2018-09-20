package com.kpa.gotostudymvp.data

/**
 *author: mr.kong
 *Date:2018/9/18
 *description:
 *project name:gotoStudyMvp
 **/

data class MovieSubject(
        val count: Int,
        val start: Int,
        val total: Int,
        val subjects: List<Subject>,
        val title: String
)

data class Subject(
        val rating: Rating,
        val genres: List<String>,
        val title: String,
        val casts: List<Cast>,
        val collect_count: Int,
        val original_title: String,
        val subtype: String,
        val directors: List<Director>,
        val year: String,
        val images: Images,
        val alt: String,
        val id: String
)

data class Cast(
        val alt: String,
        val avatars: Avatars,
        val name: String,
        val id: String
)

data class Avatars(
    val small: String,
    val large: String,
    val medium: String
)

data class Director(
        val alt: String,
        val avatars: Avatars,
        val name: String,
        val id: String
)

data class Images(
    val small: String,
    val large: String,
    val medium: String
)

data class Rating(
    val max: Int,
    val average: Double,
    val stars: String,
    val min: Int
)