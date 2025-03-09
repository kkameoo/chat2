package com.example.demo.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChatMessage;
import com.example.demo.dto.ChatRoom;
import com.example.demo.dto.MessageRequestDto;
import com.example.demo.dto.MessageResponseDto;
import com.example.demo.service.ChatService;
import com.example.demo.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatController {
	
	private final MessageService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageResponseDto sendChatMessage(MessageRequestDto requestDto) {
        return messageService.processMessage(requestDto);
    }
	
}
