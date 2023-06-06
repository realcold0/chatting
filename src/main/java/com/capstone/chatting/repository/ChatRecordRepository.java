package com.capstone.chatting.repository;

import com.capstone.chatting.DTO.ChatRecordDto;
import com.capstone.chatting.domain.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRecordRepository extends JpaRepository<ChatRecord, Long> {

    @Query("select c from ChatRecord c where c.roomType = \'Multi\' and c.roomId = :groupId order by c.send_time desc")
    List<ChatRecord> findGroupChatById(@Param("groupId") String groupId);

    @Query("select c from ChatRecord c where c.roomType = \'Single\' and c.roomId = :singleId order by c.send_time desc")
    List<ChatRecord> findSingleChatById(@Param("singleId") String singleId);

}