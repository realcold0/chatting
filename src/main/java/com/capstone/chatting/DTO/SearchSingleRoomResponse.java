package com.capstone.chatting.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class SearchSingleRoomResponse {
    private Long userId;
    private Long targetId;
    private LocalDateTime searchTime;

    public SearchSingleRoomResponse(Long userId, Long targetId, LocalDateTime searchTime) {
        this.userId = userId;
        this.targetId = targetId;
        this.searchTime = searchTime;
    }
}
