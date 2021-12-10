package com.poker.planning.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private PokerPlanningSession pokerSession;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Collection<Vote> votes;

}
