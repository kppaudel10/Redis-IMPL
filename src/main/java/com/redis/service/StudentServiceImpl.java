package com.redis.service;

import com.redis.entity.Student;
import com.redis.pojo.StudentPojo;
import com.redis.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    @CacheEvict(value = "student", key = "#studentPojo.rollNo")
    public StudentPojo saveStudent(StudentPojo studentPojo) {
        Student student = Student.builder()
                .id(studentPojo.getId())
                .name(studentPojo.getName())
                .address(studentPojo.getAddress())
                .age(studentPojo.getAge())
                .rollNo(studentPojo.getRollNo()).build();
        studentRepo.save(student);
        return studentPojo;
    }

    @Override
    @Cacheable("students")
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }
}
