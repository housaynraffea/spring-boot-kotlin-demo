package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("name", "Kari")
        model.addAttribute("totalVisits", 42)
        return "index"
    }
    
    @GetMapping("/about")
    fun about(): String {
        return "about"
    }
    
    @GetMapping("/overview")
    fun overview(): String {
        return "overview"
    }
}