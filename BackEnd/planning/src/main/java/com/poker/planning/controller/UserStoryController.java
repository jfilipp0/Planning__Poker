package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.UserStory;
import com.poker.planning.service.UserStoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/story")
@AllArgsConstructor
public class UserStoryController {
    
    private UserStoryService userStoryService;

    @PostMapping
    public void create(@RequestBody UserStory story) {
        userStoryService.save(story);
    }

    @GetMapping
    public List<UserStory> getAll() {
        return userStoryService.getAll();
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        userStoryService.delete(id);
    }

}
