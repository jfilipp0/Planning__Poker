package com.poker.planning.repository;

import java.util.Collection;

import com.poker.planning.model.Vote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, String> {
    
    Collection<Vote> findByPokerSessionId(String id);

}
