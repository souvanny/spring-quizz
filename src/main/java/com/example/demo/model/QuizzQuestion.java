package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizz_question")
public class QuizzQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "type_choice")
    private int typeChoice;
    public int getTypeChoice() {
        return typeChoice;
    }
    public void setTypeChoice(int typeChoice) {
        this.typeChoice = typeChoice;
    }

    @Column(name = "title")
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public QuizzQuestion(int typeChoice, String title) {
        this.typeChoice = typeChoice;
        this.title = title;
    }

//    public QuizzQuestion(int id, String title) {
//        this.id = id;
//        this.title = title;
//    }

    public QuizzQuestion() {
    }
}
