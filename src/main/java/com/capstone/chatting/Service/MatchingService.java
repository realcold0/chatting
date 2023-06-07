package com.capstone.chatting.Service;

import com.capstone.chatting.DTO.*;
import com.capstone.chatting.domain.ChatRecord;
import com.capstone.chatting.domain.GroupChatRoom;
import com.capstone.chatting.domain.SingleChatRoom;
import com.capstone.chatting.repository.ChatRecordRepository;
import com.capstone.chatting.repository.GroupChatRoomRepository;
import com.capstone.chatting.repository.SingleChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchingService {

    @Autowired
    private final GroupChatRoomRepository groupChatRoomRepository;

    @Autowired
    private final SingleChatRoomRepository singleChatRoomRepository;

    @Autowired
    private final ChatRecordRepository chatRecordRepository;

    @Transactional
    public void processMatch(MatchingMessage messages){
        List<MatchingMember> members = messages.getMatchingMembers();

        Long jerry_id;

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
            int a = rd.nextInt()%4;


            if(maleList.size() == 4){//남자가 4명이면 이 중에 1명이 제리
                jerry_id = maleList.get(a).getId();
                GroupChatRoomDto groupChatRoomDto = new GroupChatRoomDto(mid.get(0),mid.get(1),mid.get(2),mid.get(3),mid.get(4),mid.get(5),jerry_id);
                groupChatRoomRepository.save(groupChatRoomDto.createGroupChatRoom());
            }
            else if(femaleList.size() == 4){ //여자가 4명이면 이 중에 1명이 제리
                jerry_id = femaleList.get(a).getId();
                GroupChatRoomDto groupChatRoomDto = new GroupChatRoomDto(mid.get(0),mid.get(1),mid.get(2),mid.get(3),mid.get(4),mid.get(5),jerry_id);
                groupChatRoomRepository.save(groupChatRoomDto.createGroupChatRoom());
            }
            else{
                System.out.println("성비가 4:2로 오지 않았습니다.");
                throw new RuntimeException("성비가 옳바르게 오지 않았습니다.");
            }

            MatchingResultDto resultDto = groupChatRoomRepository.findMatchingResultDtoByJerryId(jerry_id).get(0);
            //승환아 이걸 처리해줘
        }
        else {
            System.out.println("싱글도 멀티도 아닌 경우입니다.");
            throw new RuntimeException("RabbitMq Matching Queue 에서 잘못된 값을 가져왔습니다.");
        }
    }

    @Transactional
    public List<SingleChatRoom> searchSingleRoom(Long mid){
        return singleChatRoomRepository.findSingleRoomById(mid);
    }

    @Transactional
    public List<ChatRecord> searchSingleRecord(String singleId){
        return chatRecordRepository.findSingleChatById(singleId);
    }

    @Transactional
    public List<ChatRecord> searchGroupRecord(String groupId){
        return chatRecordRepository.findGroupChatById(groupId);

    }

    @Transactional
    public List<GroupChatRoom> searchGroupRoom(Long mid){
        return groupChatRoomRepository.findGroupRoomById(mid);
    }

    @Transactional
    public GroupChatRoom updateGroupChatStatus(String roomId){
        Long id = Long.parseLong(roomId);
        GroupChatRoom groupChatRoom = groupChatRoomRepository.findById(id).get();
        groupChatRoom.setStatus(false);
        return groupChatRoom;
    }

}
