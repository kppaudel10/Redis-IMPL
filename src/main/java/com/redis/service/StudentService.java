package com.redis.service;

import com.redis.entity.Student;
import com.redis.pojo.StudentPojo;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
public interface StudentService {

    StudentPojo saveStudent(StudentPojo studentPojo);

    List<Student> getStudentList();

}
