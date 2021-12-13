package com.poker.planning.service;

import java.util.List;
import java.util.Optional;

import com.poker.planning.model.UserStory;
import com.poker.planning.repository.UserStoryRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserStoryService {

    private UserStoryRepository userStoryRepository;

    public UserStory save(UserStory story) {
        return userStoryRepository.save(story);
    }

    public List<UserStory> getAll() {
        return userStoryRepository.findAll();
    }

    public void delete(String id) {
        userStoryRepository.deleteById(id);
    }

    public Optional<UserStory> findById(String id) {
        return userStoryRepository.findById(id);
    }
    
}
