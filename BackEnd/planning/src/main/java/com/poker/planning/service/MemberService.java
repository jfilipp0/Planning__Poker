package com.poker.planning.service;

import java.util.List;

import com.poker.planning.model.Member;
import com.poker.planning.repository.MemberRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
    
    private MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public void delete(String id) {
        memberRepository.deleteById(id);
    }
}
