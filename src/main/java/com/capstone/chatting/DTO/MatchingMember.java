package com.capstone.chatting.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MatchingMember {
    private Long id;
    private String gender;

    public MatchingMember(Long id, String gender){
        this.id = id;
        this.gender = gender;
    }
}
