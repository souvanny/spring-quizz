package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class AnswerController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("questions/{questionId}/answers")
    public List<Answer> getAnswersForQuestion(@PathVariable Long questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            return answerRepository.findByQuestionId(questionId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found with id: " + questionId);
        }
    }

    @GetMapping("answers/{id}")
    public ResponseEntity<Answer> getAnswersById(@PathVariable Long id) {
        Optional<Answer> answer = answerRepository.findById(id);
      if(answer.isPresent()) {
          return ResponseEntity.ok(answer.get());
      } else {
          return ResponseEntity.notFound().build();
      }
    }
}
