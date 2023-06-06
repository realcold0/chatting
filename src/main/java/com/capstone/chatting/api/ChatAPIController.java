package com.capstone.chatting.api;

import com.capstone.chatting.DTO.ChatRecordDto;
import com.capstone.chatting.DTO.Result;
import com.capstone.chatting.DTO.SearchSingleRoomResponse;
import com.capstone.chatting.Service.ChatRoomService;
import com.capstone.chatting.Service.MatchingService;
import com.capstone.chatting.Service.MessageSenderService;
import com.capstone.chatting.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatAPIController {
    private final MatchingService matchingService;

    /*
     *
     * 싱글 채팅 리스트
     * /api/v1/single_room?mid={id}
     */
    @GetMapping("/api/v1/single_room")
    public Result getSingleRoomList(@RequestParam("mid") Long mid){

        List<SingleChatRoom> collection = new ArrayList<>();
        collection = matchingService.searchSingleRoom(mid);

        return new Result(collection.size(), collection);
    }


    /*
     * 채팅 내역
     * single
     * /api/v1/single_records?singleId={id}
     */
    @GetMapping("/api/v1/single_records")
    public Result getSingleChatRecord(@RequestParam("singleId") String singleId){

        List<ChatRecord> collection = new ArrayList<>();
        collection =  matchingService.searchSingleRecord(singleId);

        System.out.println(collection.size());
        System.out.println(collection);

        return new Result(collection.size(), collection);
    }


    /*
     *  Group 채팅 내역
     *  /api/v1/group_records?groupId={id}
     */
    @GetMapping("/api/v1/group_records")
    public Result getChatRecords(@RequestParam("groupId") String groupId) {
        List<ChatRecord> collection = new ArrayList<>();
        collection =  matchingService.searchGroupRecord(groupId);

        return new Result(collection.size(), collection);
    }

    /*

        Group 채팅
        /api/v1/group_room?mid={id}

     */

    @GetMapping("/api/v1/group_room")
    public Result getGroupRoomList(@RequestParam("mid") Long mid){
        List<GroupChatRoom> collection = new ArrayList<>();
        collection = matchingService.searchGroupRoom(mid);

        return new Result(collection.size(), collection);
    }

    /*
    *   GroupChatRoom Status false 로 변경
    *   /api/v1/group_status/{id}
    *
    */
    @PostMapping("/api/v1/group_status/{roomId}")
    public GroupChatRoom setGroupStatusFalse(@PathVariable("roomId") String roomId){
        return matchingService.updateGroupChatStatus(roomId);
    }

}
