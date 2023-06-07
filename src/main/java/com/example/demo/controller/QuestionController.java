package com.example.demo.controller;

import com.example.demo.model.Answer;
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
	@CrossOrigin(origins = "*")
    public List<Question> getQuestions() {return this.questionRepository.findAll();}

    @GetMapping("questions/{id}")
    public Optional<Question> getQuestionsById(@PathVariable Long id) {
        return Optional.ofNullable(this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : " + id)));
    }

    @GetMapping("questions/validate/{validateQuestion}")
    public List<Question> getQuestionByValidateQuestion(@PathVariable boolean validateQuestion) {
        return questionRepository.findByValidateQuestion(validateQuestion);
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

            List<Answer> answers = newQuestion.getAnswers();

            for(Answer answer : answers) {
                answer.setQuestion(newQuestion);
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

    @PutMapping("questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question non trouvé avec id : " + id));

        question.setValidateQuestion(questionDetails.isValidateQuestion());
        question.setTitle(questionDetails.getTitle());
        question.setHashtags(questionDetails.getHashtags());

        // Mettre à jour les réponses
        List<Answer> existingAnswers = question.getAnswers();
        List<Answer> updatedAnswers = questionDetails.getAnswers();

        // Mettre à jour les réponses existantes
        for (int i = 0; i < Math.min(existingAnswers.size(), updatedAnswers.size()); i++) {
            Answer existingAnswer = existingAnswers.get(i);
            Answer updatedAnswer = updatedAnswers.get(i);

            existingAnswer.setTitle(updatedAnswer.getTitle());
            existingAnswer.set_correct(updatedAnswer.is_correct());
            // Mettre à jour les autres propriétés de la réponse, si nécessaire
        }

        // Ajouter les nouvelles réponses
        for (int i = existingAnswers.size(); i < updatedAnswers.size(); i++) {
            Answer newAnswer = updatedAnswers.get(i);
            newAnswer.setQuestion(question);
            existingAnswers.add(newAnswer);
        }

        final Question updateQuestion = questionRepository.save(question);
        return ResponseEntity.ok(updateQuestion);
    }

    @GetMapping("questions/user/{userId}")
    public ResponseEntity<List<Question>> getQuestionsByUser(@PathVariable Long userId) {
        List<Question> questions = questionRepository.findByUserId(userId);

        // Vérification si les questions ont été trouvées
        if(!questions.isEmpty()) {
            return ResponseEntity.ok(questions);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}


