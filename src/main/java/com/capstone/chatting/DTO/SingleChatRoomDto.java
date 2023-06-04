package com.capstone.chatting.DTO;

import com.capstone.chatting.domain.SingleChatRoom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleChatRoomDto {
    private Long mid_1;
    private Long mid_2;

    public SingleChatRoomDto(Long mid_1, Long mid_2) {
        this.mid_1 = mid_1;
        this.mid_2 = mid_2;
    }

    public SingleChatRoom createSingleRoom(){
        return new SingleChatRoom(mid_1, mid_2);
    }
}
