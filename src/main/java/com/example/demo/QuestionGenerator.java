package com.example.demo;


import java.time.LocalDateTime;
import java.util.Random;

import com.example.demo.model.Question;
import com.example.demo.model.Answer;
import com.example.demo.model.Question.Type_choice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionGenerator {

	public static List<Question> generateQuestions() {
		List<Question> questions = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			Question question = new Question();
			question.setTitle("Question " + i);
			question.setTypeChoice(Type_choice.UNIQUE);
			question.setDateCreated(new Date());
			question.setHashtags("Tag" + i);

			List<Answer> answers = new ArrayList<>();
			for (int j = 1; j <= 4; j++) {
				Answer answer = new Answer();
				answer.setTitle("Réponse " + j + " de la Question " + i);
				answer.setDate_created(LocalDateTime.now());
				answer.setQuestion(question);

				answers.add(answer);
			}

			question.setAnswers(answers);
			questions.add(question);
		}

		return questions;
	}

	public static void main(String[] args) {
		List<Question> generatedQuestions = generateQuestions();
		for (Question question : generatedQuestions) {
			System.out.println("Question: " + question.getTitle());
			for (Answer answer : question.getAnswers()) {
				System.out.println("  Réponse: " + answer.getTitle());
			}
			System.out.println();
		}
	}
}

