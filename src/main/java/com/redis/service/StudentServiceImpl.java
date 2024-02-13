package com.redis.service;

import com.redis.pojo.StudentPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentPojo saveStudent(StudentPojo studentPojo) {
        return null;
    }
}
