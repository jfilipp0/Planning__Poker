package com.poker.planning.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class PokerPlanningSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Collection<Member> members;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Collection<UserStory> usersStories;

}
