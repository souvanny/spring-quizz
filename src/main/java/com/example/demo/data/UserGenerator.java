package com.example.demo.data;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserGenerator {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void generateUsers() {
        List<User> users = generateRandomUsers(5);
        userRepository.saveAll(users);
    }

    public static List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setPassword(faker.internet().password());
            user.setEnabled(faker.random().nextBoolean());
            user.setProvider(faker.lorem().word());

            users.add(user);
        }

        return users;
    }
}
