package com.redis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@Builder
public class Student implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    private Integer age;

    @Column(name = "roll_no")
    private Integer rollNo;

}
