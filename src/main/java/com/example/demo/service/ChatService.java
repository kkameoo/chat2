package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChatMessage;
import com.example.demo.dto.ChatRoom;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
public class ChatService {
	
	private final RedisPublisher redisPublisher;
	
	public ChatService(RedisPublisher redisPublisher) {
	       this.redisPublisher = redisPublisher;
	   }

	public void sendMessage(String channel, String message) {
	       redisPublisher.publish(channel, message);
	   }
}
