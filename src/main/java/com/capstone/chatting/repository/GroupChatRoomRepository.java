package com.capstone.chatting.repository;

import com.capstone.chatting.DTO.MatchingResultDto;
import com.capstone.chatting.domain.GroupChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupChatRoomRepository extends JpaRepository<GroupChatRoom, Long>{

    @Query("select g from GroupChatRoom g where mid1 = :mid or mid2 = :mid or mid3 = :mid or mid4 = :mid or mid5 = :mid or mid6 = :mid")
    List<GroupChatRoom> findGroupRoomById(@Param("mid") Long mid);

    @Query("select new com.capstone.chatting.DTO.MatchingResultDto"+
            "(g.mid1, g.mid2, g.mid3, g.mid4, g.mid5, g.mid6, g.jerry_id, g.id, g.created_at, g.status) from"+
            " GroupChatRoom g where g.jerry_id = :jerry_id order by g.created_at")
    List<MatchingResultDto> findMatchingResultDtoByJerryId(@Param("jerry_id") Long jerry_id);

}
