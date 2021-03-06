package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.PokerPlanningSession;
import com.poker.planning.service.PokerPlanningSessionService;

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
@RequestMapping("/session")
@AllArgsConstructor
public class PokerPlanningSessionController {
    private PokerPlanningSessionService sessionService;

    // CREATE
    @PostMapping
    public PokerPlanningSession create(@RequestBody PokerPlanningSession session) {
        return sessionService.save(session);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<PokerPlanningSession>> getAll() {
        List<PokerPlanningSession> sessions = (List<PokerPlanningSession>) sessionService.getAll();
        return new ResponseEntity<>(sessions, sessions.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody PokerPlanningSession session) {
        return sessionService.findById(id).map(record -> {
            record.setTitle(session.getTitle());
            record.setMembers(session.getMembers());
            record.setUsersStories(session.getUsersStories());
            PokerPlanningSession updated = sessionService.save(record);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateByPatch(@PathVariable("id") String id, @RequestBody PokerPlanningSession session){
		return sessionService.findById(id).map(record -> {
			record.setTitle(session.getTitle() != null ? session.getTitle() : record.getTitle());
			record.setMembers(session.getMembers() != null ? session.getMembers() : record.getMembers());
			record.setUsersStories(session.getUsersStories() != null ? session.getUsersStories() : record.getUsersStories());
			PokerPlanningSession updated = sessionService.save(record);
			
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

    // DELETE
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable String id) {
        return sessionService.findById(id).map(record -> {
			sessionService.delete(id);
			
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return sessionService.findById(id).map(record -> {
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
    }
    
}
