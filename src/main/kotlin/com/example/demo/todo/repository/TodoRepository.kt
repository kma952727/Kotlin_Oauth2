package com.example.demo.todo.repository

import com.example.demo.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

/**
 * 테스트용
 */
interface TodoRepository : JpaRepository<Todo, Long>