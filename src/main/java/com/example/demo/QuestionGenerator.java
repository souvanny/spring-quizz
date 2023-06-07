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
		//List<User> generatedUsers = UserGenerator.generateRandomUsers(5);

		// Générer les questions et les réponses
		//List<Question> generatedQuestions = new ArrayList<>();

		/*for (int i = 1; i <= 10; i++){
			Question question = new Question();
			question.setTitle("Question " + i);
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
		}*/

		// Associer les questions aux utilisateurs
		/*for (int i = 0; i < generatedQuestions.size(); i++) {
			Question question = generatedQuestions.get(i);
			User user = generatedUsers.get(i % generatedUsers.size()); // Récupérer un utilisateur en boucle
			question.setUser(user);
		}

		UserRepository userRepository = context.getBean(UserRepository.class);
		QuestionRepository questionRepository = context.getBean(QuestionRepository.class);

		userRepository.saveAll(generatedUsers);
		questionRepository.saveAll(generatedQuestions);

		context.close();*/
	}
	}


