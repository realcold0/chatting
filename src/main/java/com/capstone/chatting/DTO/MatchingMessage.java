package com.capstone.chatting.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MatchingMessage {
    private List<MatchingMember> matchingMembers = new ArrayList<>();

    public MatchingMessage(List<MatchingMember> members){
        this.matchingMembers = members;
    }

}
