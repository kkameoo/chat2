package com.example.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChatMessage;

@Service
public class RedisPublisher {
	
	private final RedisTemplate<String, Object> redisTemplate;
	
	public RedisPublisher(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void publish(String topic, String message) {
		System.out.println("topic : "+ topic + "message : "+ message);
		redisTemplate.convertAndSend(topic, message);
	}
	
}
