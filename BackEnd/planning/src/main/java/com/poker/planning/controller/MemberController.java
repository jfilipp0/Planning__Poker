package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.Member;
import com.poker.planning.service.MemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    // CREATE
    @PostMapping
    public Member create(@RequestBody Member member) {
        return memberService.save(member);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        List<Member> members = (List<Member>) memberService.getAll();
        return new ResponseEntity<>(members, members.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Member member) {
        return memberService.findById(id).map(record -> {
            record.setVeiculo(member.getVeiculo());
            record.setMarca(member.getMarca().toString());
            record.setAno(member.getAno());
            record.setDescricao(member.getDescricao());
            record.setVendido(member.getVendido());
            Member updated = memberService.save(record);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateByPatch(@PathVariable("id") String id, @RequestBody Member member){
		return memberService.findById(id).map(record -> {
			record.setVeiculo(member.getVeiculo() != null ? member.getVeiculo() : record.getVeiculo());
			record.setMarca(member.getMarca() != null ? member.getMarca().toString() : record.getMarca().toString());
			record.setAno(member.getAno() != null ? member.getAno() : record.getAno());
			record.setDescricao(member.getDescricao() != null ? member.getDescricao() : record.getDescricao());
			record.setVendido(member.getVendido() != null ? member.getVendido() : record.getVendido());
			record.setCreated(member.getCreated() != null ? member.getCreated() : record.getCreated());
			Member updated = memberService.save(record);
			
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

    // DELETE
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable String id) {
        return memberService.findById(id).map(record -> {
			memberService.delete(id);
			
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return memberService.findById(id).map(record -> {
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
    }
    
}
