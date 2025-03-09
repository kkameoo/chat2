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

@RequiredArgsConstructor
@Service
public class ChatService {
	
	private Map<String, ChatRoom> chatRooms;
	private final SimpMessagingTemplate template;
	
	 @PostConstruct
	    private void init() {
	       chatRooms = new LinkedHashMap<>();
	    }

	    public List<ChatRoom> findAllRoom() {
	       return new ArrayList<>(chatRooms.values());
	    }

	    public ChatRoom findRoomById(String roomId) {
	       return chatRooms.get(roomId);
	    }

	    public ChatRoom createRoom(String name) {
	       String roomId = UUID.randomUUID().toString();
	       ChatRoom chatRoom = ChatRoom.builder()
	             .roomId(roomId)
	             .name(name)
	             .build();
	       chatRooms.put(roomId, chatRoom);
	       return chatRoom;
	    }
	    
	    // /sub을 Config에서 설정해주었다. 
	    // 그래서 Message Broker가 해당 send를 캐치하고 해당 토픽을 구독하는 모든 사람에게 메시지를 보내게 된다.
	    public void sendMessage(ChatMessage message) {
	       // 메시지 저장로직 추가
	       ChatRoom chatRoom = chatRooms.get(message.getRoomId());
	       
	       // ex) roomId가 2일때, /sub/chat/room/2를 구독하는 유저들에게 모두 메시지가 보낸다.
	       template.convertAndSend("/sub/chat/room/" + chatRoom.getRoomId(), message);
	    }
	
	

}
