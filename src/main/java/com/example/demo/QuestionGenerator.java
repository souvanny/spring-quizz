package com.example.demo;


import com.example.demo.data.UserGenerator;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class QuestionGenerator {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuestionGenerator.class, args);

		// Générer les utilisateurs
		UserGenerator userGenerator = new UserGenerator();
		List<User> generatedUsers = userGenerator.generateRandomUsers(5);

		// Générer les questions et les réponses
		List<Question> generatedQuestions = new ArrayList<>();

		for (int i = 1; i <= 10; i++){
			Question question = new Question();
			question.setTitle("Question " + i);
			question.setTypeChoice(Question.Type_choice.UNIQUE);
			question.setHashtags("Tag" + i);

			List<Answer> answers = new ArrayList<>();
			for(int j = 1; j <= 2; j++){
				Answer answer = new Answer();
				answer.setTitle("Réponse " + j + " de la question " + i);
				answer.setQuestion(question);

				answers.add(answer);
			}
				question.setAnswers(answers);
				generatedQuestions.add(question);
		}

		// Associer les questions aux utilisateurs
		for(int i = 0; i < generatedUsers.size(); i++) {
			User user = generatedUsers.get(i);
			List<Question> associatedQuestions = generatedQuestions.subList(i * 2, (i * 2) + 2);
			user.setAssociatedQuestions(associatedQuestions);
		}

		UserRepository userRepository = context.getBean(UserRepository.class);
		QuestionRepository questionRepository = context.getBean(QuestionRepository.class);

		userRepository.saveAll(generatedUsers);
		questionRepository.saveAll(generatedQuestions);

		context.close();
	}
}


