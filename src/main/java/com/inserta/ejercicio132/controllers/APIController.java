package com.inserta.ejercicio132.controllers;

import com.inserta.ejercicio132.services.UserService;
import com.inserta.ejercicio132.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    private final UserService userService;
    @Autowired
    public APIController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/usuarios")
    public List<User> usuarios() {
        return userService.getAll();
    }

    @GetMapping("/usuario/id/{id}")
    public User user(
            @PathVariable Integer id
    ) {
        return this.userService.getById(id);
    }

    @GetMapping("/usuario/email/{email}")
    public User users(
            @PathVariable String email
    ) {
        return this.userService.getByEmail(email);
    }

    @GetMapping("/usuarios/email/{email}")
    public List<User> usuario(
            @PathVariable String email
    ) {
        return this.userService.getByEmails(email);
    }
}
