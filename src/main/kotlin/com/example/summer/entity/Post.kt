package com.example.summer.entity

import com.example.summer.dtos.PostDto
import jakarta.persistence.*
import jakarta.persistence.GenerationType
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    val title: String,

    val description: String,
)

fun Post.toDto(): PostDto = PostDto(
    id = id,
    title = title,
    description = description,
)

