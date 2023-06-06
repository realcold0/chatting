package com.capstone.chatting.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MatchingResultDto {
    //회원 정보
    private String mid1;
    private String mid2;
    private String mid3;
    private String mid4;
    private String mid5;
    private String mid6;

    //제리 정보
    private String jerry_id;

    //room id
    private Long id;

    //생성시간
    private LocalDateTime created_at;

    private boolean status;

    public MatchingResultDto(String mid1, String mid2, String mid3, String mid4, String mid5, String mid6, String jerry_id, Long id, LocalDateTime created_at, boolean status) {
        this.mid1 = mid1;
        this.mid2 = mid2;
        this.mid3 = mid3;
        this.mid4 = mid4;
        this.mid5 = mid5;
        this.mid6 = mid6;
        this.jerry_id = jerry_id;
        this.id = id;
        this.created_at = created_at;
        this.status = status;
    }
}
