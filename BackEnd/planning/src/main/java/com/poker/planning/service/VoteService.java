package com.poker.planning.service;

import java.util.List;

import com.poker.planning.model.Vote;
import com.poker.planning.repository.VoteRepository;

import org.springframework.stereotype.Service;

@Service
public class VoteService {
    
    private VoteRepository voteRepository;

    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    public void delete(String id) {
        voteRepository.deleteById(id);
    }

}
