package com.capstone.chatting.DTO;

import com.capstone.chatting.domain.GroupChatRoom;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GroupChatRoomDto {
    private Long mid_1;
    private Long mid_2;
    private Long mid_3;
    private Long mid_4;
    private Long mid_5;
    private Long mid_6;
    private Long jerryId;

    public GroupChatRoomDto(Long mid_1, Long mid_2, Long mid_3, Long mid_4, Long mid_5, Long mid_6, Long jerryId) {
        this.mid_1 = mid_1;
        this.mid_2 = mid_2;
        this.mid_3 = mid_3;
        this.mid_4 = mid_4;
        this.mid_5 = mid_5;
        this.mid_6 = mid_6;
        this.jerryId = jerryId;
    }

    public GroupChatRoom createGroupChatRoom(){
        return new GroupChatRoom(mid_1,mid_2,mid_3,mid_4,mid_5,mid_6,jerryId);
    }
}
