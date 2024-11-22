package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student registerStudent(Student student) {
        if (repository.findByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use.");
        }
        return repository.save(student);
    }

    public Optional<Student> login(String email, String password) {
        return repository.findByEmail(email)
                         .filter(student -> student.getPassword().equals(password));
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }
}