package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.Vote;
import com.poker.planning.service.VoteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vote")
@AllArgsConstructor
public class VoteController {
    
    private VoteService voteService;

    // CREATE
    @PostMapping
    public Vote create(@RequestBody Vote vote) {
        return voteService.save(vote);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Vote>> getAll() {
        List<Vote> votes = (List<Vote>) voteService.getAll();
        return new ResponseEntity<>(votes, votes.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Vote vote) {
        return voteService.findById(id).map(record -> {
            record.setValue(vote.getValue());
            record.setMember(vote.getMember());
            record.setStory(vote.getStory());
            Vote updated = voteService.save(record);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateByPatch(@PathVariable("id") String id, @RequestBody Vote vote){
		return voteService.findById(id).map(record -> {
			record.setValue(vote.getValue() != null ? vote.getValue() : record.getValue());
			record.setMember(vote.getMember() != null ? vote.getMember() : record.getMember());
			record.setStory(vote.getStory() != null ? vote.getStory() : record.getStory());
			Vote updated = voteService.save(record);
			
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

    // DELETE
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable String id) {
        return voteService.findById(id).map(record -> {
			voteService.delete(id);
			
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return voteService.findById(id).map(record -> {
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
    }

}
