package com.poker.planning.controller;

import java.util.List;

import com.poker.planning.model.UserStory;
import com.poker.planning.service.UserStoryService;

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
@RequestMapping("/story")
@AllArgsConstructor
public class UserStoryController {
    
    private UserStoryService storiesService;

    // CREATE
    @PostMapping
    public UserStory create(@RequestBody UserStory story) {
        return storiesService.save(story);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<UserStory>> getAll() {
        List<UserStory> stories = (List<UserStory>) storiesService.getAll();
        return new ResponseEntity<>(stories, stories.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody UserStory story) {
        return storiesService.findById(id).map(record -> {
            record.setDescription(story.getDescription());
            record.setStatus(story.getStatus());
            record.setVotes(story.getVotes());
            UserStory updated = storiesService.save(record);

            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateByPatch(@PathVariable("id") String id, @RequestBody UserStory story){
		return storiesService.findById(id).map(record -> {
			record.setDescription(story.getDescription() != null ? story.getDescription() : record.getDescription());
			record.setStatus(story.getStatus() != null ? story.getStatus() : record.getStatus());
			record.setVotes(story.getVotes() != null ? story.getVotes() : record.getVotes());
			UserStory updated = storiesService.save(record);
			
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

    // DELETE
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable String id) {
        return storiesService.findById(id).map(record -> {
			storiesService.delete(id);
			
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return storiesService.findById(id).map(record -> {
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
    }

}
