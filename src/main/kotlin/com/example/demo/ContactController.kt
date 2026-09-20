package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ContactController {
    
    @GetMapping("/contact")
    fun showForm(): String {
        return "contact"
    }
    
    @PostMapping("/contact")
    fun getForm(
        @RequestParam name: String,
        @RequestParam message: String,
        model: Model
    ): String {
        model.addAttribute("name", name)
        return "redirect:/thanks?name=$name"
    }
    
    @GetMapping("/thanks")
    fun thanks(
        @RequestParam(defaultValue = "der") name: String,
        model: Model
    ): String {
        model.addAttribute("name", name)
        return "thanks"
    }
}