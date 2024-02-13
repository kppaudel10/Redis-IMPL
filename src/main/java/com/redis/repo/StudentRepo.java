package com.redis.repo;

import com.redis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
public interface StudentRepo extends JpaRepository<Student, Long> {
}
