package com.example.demo.service;

import com.example.demo.dto.MessageRequestDto;
import com.example.demo.dto.MessageResponseDto;

public interface MessageService {
	MessageResponseDto processMessage(MessageRequestDto requestDto);
}
