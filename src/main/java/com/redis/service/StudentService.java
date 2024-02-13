package com.redis.service;

import com.redis.pojo.StudentPojo;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
public interface StudentService {

    StudentPojo saveStudent(StudentPojo studentPojo);

}
