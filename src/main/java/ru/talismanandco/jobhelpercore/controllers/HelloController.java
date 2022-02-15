package ru.talismanandco.jobhelpercore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.talismanandco.jobhelpercore.dto.User;

@RestController
public class HelloController {

    @GetMapping("/user")
    public User hello() {

        User user = User.builder()
                .id("1")
                .name("talisman")
                .password("abc")
                .build();

        System.out.println(user);
        return user;
    }
}
