package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.Member;
import com.poker.planning.service.MemberService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping
    public void create(@RequestBody Member member) {
        memberService.save(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return memberService.getAll();
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

    //@GetMapping("/{id}")
    //public Member getById(@PathVariable String id){
    //    return memberService.findByID(id)
    //}
    
}
