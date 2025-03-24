package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageRequestDto;
import com.example.demo.dto.MessageResponseDto;
@Service
public class MessageServiceImpl implements MessageService{
	
	@Override
	public MessageResponseDto processMessage(MessageRequestDto requestDto) {
		System.out.println(requestDto.getContent());
		System.out.println(requestDto.getSender());
		return new MessageResponseDto(requestDto.getContent());
	}
}
