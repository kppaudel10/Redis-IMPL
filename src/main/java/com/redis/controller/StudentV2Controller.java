package com.redis.controller;

import com.redis.entity.Student;
import com.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-14
 */
@RestController
@RequestMapping("/api/v2/student/")
@RequiredArgsConstructor
public class StudentV2Controller {
    private final StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }
}
