package com.inserta.ejercicio132.users;

import lombok.*;

import java.util.Random;
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class User {
    private int id;
    private String email;
    private String password;


    public User(String email, String password) {
        Random r = new Random();
    	this.id = Math.abs(r.nextInt()); //valor aleatorio positivo en el rango de los enteros
        this.email = email;
        this.password = password;
    }
}