package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TasksController {
    
    @GetMapping("/tasks")
    fun home(model: Model): String {
        val myTasks = listOf("Read about Spring Boot", "Make a template", "Style the page with CSS")
        model.addAttribute("tasks", myTasks)
        return "tasks"
    }
}