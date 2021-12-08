package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.Task;
import com.poker.planning.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskRepository  taskRepositories;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Task> list() {
        return taskRepositories.findAll();
    }
    
}
