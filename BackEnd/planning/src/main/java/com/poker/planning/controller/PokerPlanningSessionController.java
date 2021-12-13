package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.PokerPlanningSession;
import com.poker.planning.service.PokerPlanningSessionService;

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
            record.setVeiculo(session.getVeiculo());
            record.setMarca(session.getMarca().toString());
            record.setAno(session.getAno());
            record.setDescricao(session.getDescricao());
            record.setVendido(session.getVendido());
            PokerPlanningSession updated = sessionService.save(record);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateByPatch(@PathVariable("id") String id, @RequestBody PokerPlanningSession session){
		return sessionService.findById(id).map(record -> {
			record.setVeiculo(session.getVeiculo() != null ? session.getVeiculo() : record.getVeiculo());
			record.setMarca(session.getMarca() != null ? session.getMarca().toString() : record.getMarca().toString());
			record.setAno(session.getAno() != null ? session.getAno() : record.getAno());
			record.setDescricao(session.getDescricao() != null ? session.getDescricao() : record.getDescricao());
			record.setVendido(session.getVendido() != null ? session.getVendido() : record.getVendido());
			record.setCreated(session.getCreated() != null ? session.getCreated() : record.getCreated());
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
