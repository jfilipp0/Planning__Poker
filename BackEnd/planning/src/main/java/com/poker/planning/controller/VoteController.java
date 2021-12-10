package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.Vote;
import com.poker.planning.service.VoteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vote")
@AllArgsConstructor
public class VoteController {
    
    private VoteService voteService;

    @PostMapping
    public void create(@RequestBody Vote vote) {
        voteService.save(vote);
    }

    @GetMapping
    public List<Vote> getAll() {
        return voteService.getAll();
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        voteService.delete(id);
    }

}