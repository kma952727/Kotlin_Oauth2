package com.example.demo.todo.api

import com.example.demo.todo.model.Todo
import com.example.demo.todo.repository.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * 테스트용
 */
@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId:Long): Optional<Todo>?{
        return todoRepository.findById(todoId)
    }

    @PostMapping()
    fun newTodo(@RequestBody todo: Todo): Todo {
        todoRepository.save(todo)
        return todo
    }

    @PutMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("todoId") todoId:Long) {
        var target: Todo = todoRepository.findById(todoId).get()
        target.title = todo.title
        target.description = todo.description
        target.finished = todo.finished

        todoRepository.save(target)
    }
    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: Long) {
        todoRepository.deleteById(todoId)
    }
}