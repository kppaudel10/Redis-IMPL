package com.redis.service;

import com.redis.entity.Student;
import com.redis.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        if (Objects.nonNull(student)) {
            studentRepo.save(student);
        }
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepo.findById(id).get();
    }

}
