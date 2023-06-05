package com.capstone.chatting.Service;

import com.capstone.chatting.DTO.GroupChatRoomDto;
import com.capstone.chatting.DTO.MatchingMember;
import com.capstone.chatting.DTO.MatchingMessage;
import com.capstone.chatting.DTO.SingleChatRoomDto;
import com.capstone.chatting.domain.GroupChatRoom;
import com.capstone.chatting.repository.GroupChatRoomRepository;
import com.capstone.chatting.repository.SingleChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MatchingService {

    @Autowired
    GroupChatRoomRepository groupChatRoomRepository;

    @Autowired
    SingleChatRoomRepository singleChatRoomRepository;

    public void processMatch(MatchingMessage messages){
        List<MatchingMember> members = messages.getMatchingMembers();

        int jerryId;

        if(members.size() == 2){
            SingleChatRoomDto singleChatRoomDto = new SingleChatRoomDto(members.get(0).getId(), members.get(1).getId());
            singleChatRoomRepository.save(singleChatRoomDto.createSingleRoom());
        }
        else if (members.size() == 6){
            List<MatchingMember> maleList = new ArrayList<>();
            List<MatchingMember> femaleList = new ArrayList<>();
            List<Long> mid = new ArrayList<>();

            for(MatchingMember member: members){
                mid.add(member.getId());
                if(member.getGender().equals("M"))
                    maleList.add(member);
                else
                    femaleList.add(member);
            }

            Random rd = new Random();
            rd.setSeed(System.currentTimeMillis());
            jerryId = (int)(rd.nextInt()%4);


            if(maleList.size() == 4){//남자가 4명이면 이 중에 1명이 제리
                GroupChatRoomDto groupChatRoomDto = new GroupChatRoomDto(mid.get(0),mid.get(1),mid.get(2),mid.get(3),mid.get(4),mid.get(5),maleList.get(jerryId).getId());
                groupChatRoomRepository.save(groupChatRoomDto.createGroupChatRoom());
            }
            else{ //여자가 4명이면 이 중에 1명이 제리
                GroupChatRoomDto groupChatRoomDto = new GroupChatRoomDto(mid.get(0),mid.get(1),mid.get(2),mid.get(3),mid.get(4),mid.get(5),femaleList.get(jerryId).getId());
                groupChatRoomRepository.save(groupChatRoomDto.createGroupChatRoom());
            }
        }
        else {
            System.out.println("싱글도 멀티도 아닌 경우입니다.");
            throw new RuntimeException("RabbitMq Matching Queue 에서 잘못된 값을 가져왔습니다.");
        }
    }

}
