package com.hogan.designmode.web;

import com.hogan.designmode.aspect.Log;
import com.hogan.designmode.entity.StreamDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 * wujun
 * 2019/12/18 10:38
 */
@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/set")
    @Log
    public void set(@RequestParam String key, @RequestParam String value) {

        redisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("/get")
    @Log
    public Integer get(@RequestParam String key) {

        return (Integer) redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/setObj")
    @Log
    public void set(@RequestParam String key) {

        StreamDemo demo = new StreamDemo(27, "wujun");
        //redisTemplate.opsForValue().set(key, demo);
        //redisTemplate.opsForValue().set(key, demo, 60, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key, demo, 60, TimeUnit.SECONDS);
    }

    @GetMapping("/getObj")
    @Log
    public StreamDemo getApple(@RequestParam String key) {

        StreamDemo demo = (StreamDemo) redisTemplate.opsForValue().get(key);
        return demo;
    }

    @GetMapping("/local/save")
    @Log
    public void cache(@RequestParam String key, @RequestParam String value) {

        Cache cache = cacheManager.getCache("localCache");
        cache.put(key, value);
        cache.put("obj", new StreamDemo(30, "mayun"));
    }

    @GetMapping("/local/show")
    @Log
    public Object show(@RequestParam String key) {

        Cache cache = cacheManager.getCache("localCache");
        log.info((String) cache.get(key).get());
        StreamDemo demo = (StreamDemo) cache.get("obj").get();
        log.info("demo为{}", demo.getName());
        return "success";
    }


}
