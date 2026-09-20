package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusController {
    
    @GetMapping("/api/status")
    fun status(): Map<String, String> {
        return mapOf(
            "status" to "ok",
                "message" to "API is running (as it should)"
        )
    }
}