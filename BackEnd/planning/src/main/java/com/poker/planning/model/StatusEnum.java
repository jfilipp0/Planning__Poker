package com.poker.planning.model;

import java.util.stream.Stream;

public enum StatusEnum {
    PENDING("Pending"),
    VOTING("Voting"),
    VOTE("Vote");

    public final String label;
    
    StatusEnum(String label) {
        this.label = label;
    }

    public static StatusEnum resolveStatusEnum(String stringToMatch) {
        return Stream.of(StatusEnum.values()).filter(
            aEnum -> aEnum.label.equals(stringToMatch)).findFirst().orElse(StatusEnum.PENDING);
    }
}
  