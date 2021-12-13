package com.poker.planning.service;

import java.util.List;
import java.util.Optional;

import com.poker.planning.model.PokerPlanningSession;
import com.poker.planning.repository.PokerPlanningSessionRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PokerPlanningSessionService {
    
    private PokerPlanningSessionRepository pokerPlanningSessionRepository;

    public PokerPlanningSession save(PokerPlanningSession session) {
        return pokerPlanningSessionRepository.save(session);
    }

    public List<PokerPlanningSession> getAll() {
        return pokerPlanningSessionRepository.findAll();
    }

    public void delete(String id) {
        pokerPlanningSessionRepository.deleteById(id);
    }

    public Optional<PokerPlanningSession> findById(String id) {
        return pokerPlanningSessionRepository.findById(id);
    }

}
