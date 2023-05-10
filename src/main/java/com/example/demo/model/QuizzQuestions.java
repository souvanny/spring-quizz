package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizz_questions")
public class QuizzQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public QuizzQuestions(String title) {
        this.title = title;
    }

//    public QuizzQuestions(int id, String title) {
//        this.id = id;
//        this.title = title;
//    }

    public QuizzQuestions() {
    }
}
