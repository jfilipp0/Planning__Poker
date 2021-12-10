package com.poker.planning.service;

import java.util.List;

import com.poker.planning.model.PokerPlanningSession;
import com.poker.planning.repository.PokerPlanningSessionRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PokerPlanningSessionService {
    
    private PokerPlanningSessionRepository pokerPlanningSessionRepository;

    public void save(PokerPlanningSession session) {
        pokerPlanningSessionRepository.save(session);
    }

    public List<PokerPlanningSession> getAll() {
        return pokerPlanningSessionRepository.findAll();
    }

    public void delete(String id) {
        pokerPlanningSessionRepository.deleteById(id);
    }

}
