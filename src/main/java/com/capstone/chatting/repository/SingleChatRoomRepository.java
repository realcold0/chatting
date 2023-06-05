package com.capstone.chatting.repository;

import com.capstone.chatting.DTO.SearchSingleRoomResponse;
import com.capstone.chatting.domain.SingleChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingleChatRoomRepository extends JpaRepository<SingleChatRoom, Long> {

    @Query("select s from SingleChatRoom s where s.mid1 = :mid1 or s.mid2 = :mid2 order by s.created_at desc")
    List<SingleChatRoom> findSingleRoomById(@Param("mid1") Long mid1, @Param("mid2") Long mid2);

}