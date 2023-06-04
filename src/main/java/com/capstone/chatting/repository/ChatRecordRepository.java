package com.capstone.chatting.repository;

import com.capstone.chatting.domain.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRecordRepository extends JpaRepository<ChatRecord, Long> {
}