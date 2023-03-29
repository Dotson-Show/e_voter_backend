package com.evoter.vote.dto;

public record AddVoteRequest(
        Long userId,
        Long candidateId,
        Integer pollId
) {
}
