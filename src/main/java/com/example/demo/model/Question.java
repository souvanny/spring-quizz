package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {


    public enum Type_choice {
        UNIQUE,
        MULTIPLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_choice", columnDefinition = "TINYINT")
    private Type_choice typeChoice;

    private String title;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    @Column(name = "date_created", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    private String hashtags;


    public Question() {
    }

    public Question(Type_choice typeChoice, String title, Date dateCreated, String hashtags) {
        this.typeChoice = typeChoice;
        this.title = title;
        this.dateCreated = dateCreated;
        this.hashtags = hashtags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public long getId() {
        return id;
    }


    public Type_choice getTypeChoice() {
        return typeChoice;
    }

    public void setTypeChoice(Type_choice typeChoice) {
        this.typeChoice = typeChoice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }
}
