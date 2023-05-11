package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizz_answer")
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

    @Column(name = "rank")
    private int rank;
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Column(name = "is_correct")
    private int isCorrect;
    public int getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
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

    public QuizzAnswer(long idQuestion, int rank, int isCorrect, String title) {
        this.idQuestion = idQuestion;
        this.rank = rank;
        this.isCorrect = isCorrect;
        this.title = title;
    }

    public QuizzAnswer() {
    }
}
