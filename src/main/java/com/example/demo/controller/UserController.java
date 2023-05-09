package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // cela indique que les demandes provenant de cette URL sont autorisées à accéder aux ressources de l'appli Spring
@RestController // Cela signifie que toutes les méthodes de la classe annotée @RestController, renvoient directement l'objet de réponse en tant que corps de la réponse HTTP, plutot que de renvoyer un nom de vue. Cela rend plus facile de créer des API RESTful
@RequestMapping("api/") // C'est une annotation qui peut être appliqué à une méthode ou à une classe entière pour spécifier l'URL de base pour toutes les requêtes gérées par le controleur
public class UserController {

    @Autowired // Annotation de Spring qui permet l'injection de dépendances. Elle permet de dire à Spring de chercher un bean correspondant à un type donné et de l'injecter automatiquement dans la classe qui utilise cette annotation.
    private UserRepository userRepository;
    @GetMapping("users") // Annotation de Spring qui permet de mapper une requête HTTP GET à une méthode d'un controleur dans une application web. Elle permet de définir l'URI qui déclenche la méthode.
    // En utilisant ces annonations, vous pouvez facilement créer des API RESTful qui exposent des données à vos clients
    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
}
