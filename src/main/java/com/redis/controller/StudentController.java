package com.redis.controller;

import com.redis.global.GlobalApiResponse;
import com.redis.pojo.StudentPojo;
import com.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public GlobalApiResponse saveStudent(@RequestBody StudentPojo studentPojo) {
        return new GlobalApiResponse("Saved successfully", studentService.saveStudent(studentPojo));
    }

    @GetMapping
    public GlobalApiResponse getStudent() {
        return new GlobalApiResponse("Fetch successfully", studentService.getStudentList());
    }
}
