package com.example.demo.repository;

import com.example.demo.model.QuizzQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzQuestionsRepository extends JpaRepository<QuizzQuestions, Long> {
}
