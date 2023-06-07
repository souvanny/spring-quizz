package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "is_validate")
    private boolean validateQuestion;

    private String title;

    @JsonIgnoreProperties("question")
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;


    @JsonIgnore
    @Column(name = "date_created", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    //methode derappel qui s'execute avant que l'entité soir persistée dans la BDD
    @PrePersist
    protected void onCreate(){
        dateCreated = new Date();
    } // Avec cette config, a chaque fois qu'un" nouvelle entité Question est persisté en BDD,
    // la méthode onCreate sera appelée avant la persistance et attribuera la date et l'heure actuelle

    private String hashtags;


    public Question() {
    }

    public Question(String title, Date dateCreated, String hashtags, boolean validateQuestion) {
        this.title = title;
        this.dateCreated = dateCreated;
        this.hashtags = hashtags;
        this.validateQuestion = validateQuestion;
    }

}
