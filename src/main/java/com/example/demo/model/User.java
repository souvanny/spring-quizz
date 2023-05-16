package com.example.demo.model;

import jakarta.persistence.*;

@Entity //marque la classe comme étant une entité JPA, ce qui permet à l'ORM de Spring de la reconnaitre et de la traiter comme table de base de données
@Table(name = "users") // spécifie que la table associée à cette entité s'appelle "users"
public class User {

    @Id //spécifie que l'attribut 'id' est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indique que la valeur de l'identification sera générée automatiquement par la base de donnée
    private long id;

    @Column(name = "first_name") // Column spécifie que l'attribut est mappé à une colonne de la table "users". Ici, c'est firstName qui est mappé à une colonne appelé first_name
    private String firstName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "last_name")
    private String lastName;

    private String email;


    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(){}
}
