package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class Student(val studentId: Int, val firstname: String, val lastname: String, val email: String, val attended: Boolean = false)
data class NewStudent(val studentId: Int, val firstname: String, val lastname: String, val email: String)

@RestController
@RequestMapping("api/student-attendance")
class StudentAttendanceController {
    
    private val students = mutableListOf(
    Student(276691, "Per", "Arne-Pettersen", "perarnepettersen@gmail.com"),
        Student(270185, "Bobby", "Bernhildt", "bobbybernhildt@gmail.com")
    )
    
    @GetMapping
    fun getStudents(): List<Student> {
        return students
    }
    
    @GetMapping("/{studentId}")
    fun getStudent(@PathVariable studentId: Int): ResponseEntity<Student> {
        val student = students.find {it.studentId == studentId}
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        return ResponseEntity.ok(student)
    }
    
    @PostMapping
    fun registerStudent(@RequestBody new: NewStudent): ResponseEntity<Student> {
        val newStudent = Student(studentId = students.size + 1, firstname = new.firstname, lastname = new.lastname, email = new.email)
        students.add(newStudent)
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent)
    }
    
    @DeleteMapping("/{studentId}")
    fun removeStudent(@PathVariable studentId: Int): ResponseEntity<Map<String, String>> {
        students.removeIf { it.studentId == studentId }
        return ResponseEntity.ok(mapOf("result" to "deleted"))
    }
}