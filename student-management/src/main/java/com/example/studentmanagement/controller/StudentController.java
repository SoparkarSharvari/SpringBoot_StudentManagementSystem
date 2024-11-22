package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student student) {
        return ResponseEntity.ok(service.registerStudent(student));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        return service.login(email, password)
                      .map(student -> ResponseEntity.ok("Login Successful"))
                      .orElse(ResponseEntity.status(401).body("Invalid Credentials"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return service.getStudentById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(service.updateStudent(student));
    }
}