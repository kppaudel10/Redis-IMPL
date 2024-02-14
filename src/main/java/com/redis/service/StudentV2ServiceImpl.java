package com.redis.service;

import com.redis.constants.StudentConstant;
import com.redis.entity.Student;
import com.redis.repo.StudentRepo;
import com.redis.utils.CustomRedisTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-14
 */
@Service
@RequiredArgsConstructor
public class StudentV2ServiceImpl implements StudentV2Service {
    private final StudentRepo studentRepo;
    private final CustomRedisTemplate<Student> customRedisTemplate;

    @Override
    public Student saveStudent(Student student) {
        studentRepo.save(student);
        // delete from cache
        customRedisTemplate.deleteByCacheName(StudentConstant.CACHE_NAME);
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        // first check data is already exits on redis cache or not
        List<Student> studentListFromRedis = customRedisTemplate.findByCacheAndKey(StudentConstant.CACHE_NAME,
                StudentConstant.CACHE_KEY);
        if (!studentListFromRedis.isEmpty()) {
            return studentListFromRedis;
        } else {
            // fetch student data from database
            List<Student> studentListFromDatabase = studentRepo.findAll();
            // save data into redis cache
            customRedisTemplate.saveToCache(studentListFromDatabase, StudentConstant.CACHE_NAME, StudentConstant.CACHE_KEY);
            return studentListFromDatabase;
        }
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }
}
