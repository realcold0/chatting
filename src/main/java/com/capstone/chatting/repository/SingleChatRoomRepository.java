package com.capstone.chatting.repository;

import com.capstone.chatting.DTO.SearchSingleRoomResponse;
import com.capstone.chatting.domain.SingleChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingleChatRoomRepository extends JpaRepository<SingleChatRoom, Long> {

    @Query("select s from SingleChatRoom s where s.mid1 = :mid or s.mid2 = :mid order by s.created_at")
    List<SingleChatRoom> findSingleRoomById(@Param("mid") Long mid);

}