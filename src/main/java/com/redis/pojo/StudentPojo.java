package com.redis.pojo;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentPojo {

    private Long id;

    private String name;

    private String address;

    private Integer age;

    private Integer rollNo;
}
