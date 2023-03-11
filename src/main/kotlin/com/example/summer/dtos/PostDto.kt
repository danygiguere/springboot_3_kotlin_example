package com.example.summer.dtos

import com.example.summer.entity.Post
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PostDto(
    val id: Long? = null,

    @field:NotNull()
    @get:NotEmpty()
    @get:Size(min = 6, max = 25, message = "{title.size}")
    val title: String,

    @get:NotEmpty()
    @get:Size(min = 6, max = 25, message = "{description.size}")
    val description: String
)

fun PostDto.toEntity(): Post = Post(
    title = title,
    description = description
)