package com.example.summer.jpaRepositories

import com.example.summer.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//@Repository
interface PostRepository : JpaRepository<Post, Long>