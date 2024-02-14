package com.redis.controller;

import com.redis.entity.Student;
import com.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@EnableCaching
public class StudentController {

    private final StudentService studentService;

    @CacheEvict(value = "student", key = "#student.id")
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @Cacheable(value = "students")
    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudentList();
    }

    @Cacheable(value = "student", key = "#id")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }
}
