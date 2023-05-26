package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    
    @GetMapping("questions")
    public List<Question> getQuestions() {return this.questionRepository.findAll();}

    @GetMapping("questions/{id}")
    public Optional<Question> getQuestionsById(@PathVariable Long id) {
        return Optional.ofNullable(this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : " + id)));
    }

    @PostMapping("questions")
    public Question createQuestion(@RequestBody Question newQuestion) {
            if (newQuestion.getUser() == null) {
                // Gérer l'absence d'utilisateur associé à la question
                // Ici, nous attribuons un utilisateur par défaut avec un ID de 0
                User defaultUser = new User();
                defaultUser.setId(0);
                newQuestion.setUser(defaultUser);
            }
            return questionRepository.save(newQuestion);
        }


    @DeleteMapping("question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            questionRepository.deleteById(id);
            return new ResponseEntity<>("User with id " + id + " has been delete.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long questionId, @RequestBody Question questionDetails) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question non trouvé avec id : " + questionId));

        question.setMultipleChoice(questionDetails.isMultipleChoice());
        question.setTitle(questionDetails.getTitle());
        question.setHashtags(questionDetails.getHashtags());

        final Question updateQuestion = questionRepository.save(question);
        return ResponseEntity.ok(updateQuestion);
    }
}


