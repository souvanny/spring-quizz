package com.example.demo.repository;

import com.example.demo.model.QuizzAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzAnswerRepository extends JpaRepository<QuizzAnswer, Long> {
}
