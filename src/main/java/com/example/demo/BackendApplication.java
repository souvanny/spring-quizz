package com.example.demo;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.demo.repository.UserRepository;

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
//		this.userRepository.save(new User("Loghann", "M.","test@test.com"));
//		this.userRepository.save(new User("Dayann", "D.","test1@test1.com"));
//		this.userRepository.save(new User("Simplet", "R.","test2@test2.com"));
//		this.userRepository.save(new User("Atchoum", "T.","test3@test3.com"));
	}

}
