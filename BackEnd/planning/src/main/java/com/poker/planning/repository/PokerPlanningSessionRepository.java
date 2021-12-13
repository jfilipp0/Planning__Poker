package com.poker.planning.repository;

import java.util.Optional;

import com.poker.planning.model.PokerPlanningSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokerPlanningSessionRepository extends JpaRepository<PokerPlanningSession, String> {
    
    Optional<PokerPlanningSession> findById(String id);
    
}
