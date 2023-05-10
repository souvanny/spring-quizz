package com.example.demo.controller;

import com.example.demo.model.QuizzQuestions;
import com.example.demo.repository.QuizzQuestionsRepository;

import java.lang.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.request.QuizzRequest;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class QuizzController {

    @Autowired
    private QuizzQuestionsRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public QuizzController(ObjectMapper objectMapper) {
        System.out.println("QuizzController constructor ");
        this.objectMapper = objectMapper;
    }


    @PostMapping("quizz")
    public void createQuizz(@RequestBody Map<String, Object> payload) {

        System.out.println("xxxxxxxx");
        System.out.println(payload);
        System.out.println(payload.getClass());
//        QuizzRequest quizzRequest = this.objectMapper.readValue('{"question": "popi"}', QuizzRequest.class);
//        System.out.println(quizzRequest);
        System.out.println(payload.get("question"));
        System.out.println(payload.get("question").getClass());
        System.out.println(payload.get("answers"));
        System.out.println(payload.get("answers").getClass());

        ArrayList<Map<String, Object>> answers = (ArrayList<Map<String, Object>>) payload.get("answers");
        System.out.println(answers.get(0));
        System.out.println(answers.get(1));
        System.out.println(answers.get(1).get("title"));



        QuizzQuestions model = new QuizzQuestions("kkkkkkkkkkkk");
        this.repository.save(model);

    }

}
