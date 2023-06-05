package com.capstone.chatting.repository;

import com.capstone.chatting.domain.GroupChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupChatRoomRepository extends JpaRepository<GroupChatRoom, Long>{

}
