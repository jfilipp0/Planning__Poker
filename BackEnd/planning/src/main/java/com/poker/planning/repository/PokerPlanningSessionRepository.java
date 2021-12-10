package com.poker.planning.repository;

import java.util.Collection;

import com.poker.planning.model.Member;
import com.poker.planning.model.PokerPlanningSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokerPlanningSessionRepository extends JpaRepository<PokerPlanningSession, String> {
    
}
