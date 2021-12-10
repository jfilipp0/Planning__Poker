package com.poker.planning.repository;

import com.poker.planning.model.UserStory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, String> {
    
}
