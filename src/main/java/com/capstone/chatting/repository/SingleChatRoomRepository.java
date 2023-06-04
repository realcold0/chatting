package com.capstone.chatting.repository;

import com.capstone.chatting.domain.SingleChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleChatRoomRepository extends JpaRepository<SingleChatRoom, Long> {
}