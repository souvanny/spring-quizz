package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity //marque la classe comme étant une entité JPA, ce qui permet à l'ORM de Spring de la reconnaitre et de la traiter comme table de base de données
@Table(name = "user") // spécifie que la table associée à cette entité s'appelle "users"
public class User {

    @Id //spécifie que l'attribut 'id' est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indique que la valeur de l'identification sera générée automatiquement par la base de donnée
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    // public List<Question> getQuestions() {
    //     return questions;
    // }

    // public void setQuestions(List<Question> questions) {
    //     this.questions = questions;
    // }

    @ManyToMany
    @JoinTable(
            name = "user_question",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> associatedQuestions = new ArrayList<>();

    public List<Question> getAssociatedQuestions() {
        return associatedQuestions;
    }

    public void setAssociatedQuestions(List<Question> associatedQuestions) {
        this.associatedQuestions = associatedQuestions;
    }

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private String provider;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // private List<Question> questions = new ArrayList<>();
}
