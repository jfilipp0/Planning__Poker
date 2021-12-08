package com.poker.planning.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


// @Getter
// @Setter
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Collection<Vote> vote;

    public Task() {
        this.vote = new ArrayList<>();
    }

}
