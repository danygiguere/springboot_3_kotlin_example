package com.example.summer.controller

import com.example.summer.dtos.PostDto
import com.example.summer.entity.Post
import com.example.summer.jpaRepositories.PostRepository
import jakarta.validation.Valid
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController(private val postRepository: PostRepository) {

    companion object: KLogging()

    @GetMapping("/posts/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<Post>? {
        return postRepository.findById(id).map { post ->
            ResponseEntity.ok(post)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/posts")
    fun create(@Valid @RequestBody postDto: PostDto): ResponseEntity<Post> {
        val post = postRepository.save(Post(null, postDto.title, postDto.description))
        return ResponseEntity.ok(post)
    }
}