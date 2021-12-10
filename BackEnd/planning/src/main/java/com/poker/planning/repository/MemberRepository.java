package com.poker.planning.repository;

import java.util.Optional;

import com.poker.planning.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {

}
