package com.poker.planning.service;

import java.util.List;

import com.poker.planning.model.UserStory;
import com.poker.planning.repository.UserStoryRepository;

import org.springframework.stereotype.Service;

@Service
public class UserStoryService {

    private UserStoryRepository userStoryRepository;

    public void save(UserStory story) {
        userStoryRepository.save(story);
    }

    public List<UserStory> getAll() {
        return userStoryRepository.findAll();
    }

    public void delete(String id) {
        userStoryRepository.deleteById(id);
    }
}
