package com.redis.service;

import com.redis.entity.Student;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-14
 */
public interface StudentV2Service {

    Student saveStudent(Student student);

    List<Student> getStudentList();

    Student getStudent(Long id);
}
