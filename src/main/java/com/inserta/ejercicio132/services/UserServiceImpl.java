package com.inserta.ejercicio132.services;

import com.inserta.ejercicio132.services.UserService;
import com.inserta.ejercicio132.users.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> listaUsuarios;

    public UserServiceImpl() {
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public List<User> getAll() {
        return this.listaUsuarios;
    }

    @Override
    public User getById(int id) {
        for (User usuario : listaUsuarios ){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        for (User usuario : listaUsuarios ){
            if (usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<User> getByEmails(String email) {
        List<User> listaEmails = new ArrayList<>();
        for (User user : listaUsuarios){
            if (user.getEmail().startsWith(email)){
                listaEmails.add(user);
            }
        }
        return listaEmails;
    }

    @Override
    public User createUser(String email) {
        User usuario = new User(email, "");
        usuario.setPassword(Integer.toHexString(usuario.hashCode()));
        return usuario;
    }

    @Override
    public boolean add(User user) {
        return this.listaUsuarios.add(user);
    }

    @Override
    public void deleteAll() {
        this.listaUsuarios.clear();
    }
}
