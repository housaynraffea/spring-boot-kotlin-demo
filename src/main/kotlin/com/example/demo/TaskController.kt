package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class Task(val id: Int, val text: String, val finished: Boolean = false)
data class NewTask(val text: String)

@RestController
@RequestMapping("api/tasks")
class TaskController {
    
    private val tasks = mutableListOf(
    Task(1, "Read about Spring Boot"),
        Task(2, "Make an API")
    )
    
    @GetMapping
    fun getTasks(): List<Task> {
        return tasks
    }
    
    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Int): ResponseEntity<Task> {
        val task = tasks.find {it.id == id}
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        return ResponseEntity.ok(task) 
    }
    
    
    @PostMapping
    fun addTask(@RequestBody new: NewTask): ResponseEntity<Task> {
        val newTask = Task(id = tasks.size + 1, text = new.text)
        tasks.add(newTask)
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask)
    }
    
    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Int): ResponseEntity<Map<String, String>> {
        tasks.removeIf { it.id == id }
        return ResponseEntity.ok(mapOf("result" to "deleted"))
    }
}