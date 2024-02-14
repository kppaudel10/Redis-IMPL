package com.redis.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kul.paudel
 * @created at 2024-02-14
 */
@Service
@RequiredArgsConstructor
public class CustomRedisTemplate<T> {
    private final RedisTemplate<String, List<T>> redisTemplate;

    public void saveToCache(List<T> data, String cacheName, String key) {
        redisTemplate.opsForHash().put(cacheName, key, data);
    }

    public List<T> findByCacheAndKey(String cacheName, String key) {
        return (List<T>) redisTemplate.opsForHash().get(cacheName, key);
    }

    public void deleteByCacheName(String cacheName) {
        redisTemplate.delete(cacheName);
    }

    public void deleteByKey(String cacheName, String key) {
        redisTemplate.opsForHash().delete(cacheName, key);
    }

}
