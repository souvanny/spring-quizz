package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizz_questions")
public class QuizzAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "id_question")
    private long idQuestion;
    public long getIdQuestion() {
        return idQuestion;
    }
    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }


    @Column(name = "title")
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {

        this.title = title;
    }

//    public QuizzAnswer(String title) {
//        this.title = title;
//    }

    public QuizzAnswer(int idQuestion, String title) {
        this.idQuestion = idQuestion;
        this.title = title;
    }

    public QuizzAnswer() {
    }
}
