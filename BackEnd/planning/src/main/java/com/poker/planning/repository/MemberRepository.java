package com.poker.planning.repository;

import java.util.Collection;
import java.util.Optional;

import com.poker.planning.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {

    Collection<Member> findByPokerSessionId(String id);
    Collection<Member> findByVotesId(String id);
    Optional<Member> findById(String id);

}
