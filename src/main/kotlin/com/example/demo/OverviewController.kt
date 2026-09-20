package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class OverviewController {
    
    @GetMapping("/overview")
    fun overview(): String {
        return "overview"
    }
}