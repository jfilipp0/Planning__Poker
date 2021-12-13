package com.poker.planning.repository;

import java.util.Collection;
import java.util.Optional;

import com.poker.planning.model.UserStory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, String> {
    
    Collection<UserStory> findByPokerSessionId(String id);
    Optional<UserStory> findById(String id);

}
