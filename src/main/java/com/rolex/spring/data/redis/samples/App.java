package com.rolex.spring.data.redis.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class App {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) act.getBean("app");
        app.set("hello", "world");
        System.out.println(app.get("hello"));

    }
}

