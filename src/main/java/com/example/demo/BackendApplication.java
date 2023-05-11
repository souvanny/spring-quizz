package com.example.demo;

import com.example.demo.model.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.demo.repository.UserRepository;

import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories("com/example/demo/repository")
@EntityScan("com/example/demo/model")
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		for (int i = 0; i < 20; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = faker.internet().emailAddress();
			User.Dance dance = User.Dance.values()[new Random().nextInt(User.Dance.values().length)];

			this.userRepository.save(new User(firstName, lastName, email, dance));
		}
	}

}
