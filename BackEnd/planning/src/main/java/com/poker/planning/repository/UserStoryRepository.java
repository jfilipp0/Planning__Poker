package com.poker.planning.repository;

import java.util.Collection;
import java.util.Optional;

import com.poker.planning.model.UserStory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableAutoConfiguration
public interface UserStoryRepository extends JpaRepository<UserStory, String> {
    
    Collection<UserStory> findByVotesId(String id);
    Optional<UserStory> findById(String id);

}
