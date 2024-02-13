package com.redis.global;

import com.redis.pojo.StudentPojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author kul.paudel
 * @created at 2024-02-13
 */
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse {

    private String message;
    private Object data;

}
