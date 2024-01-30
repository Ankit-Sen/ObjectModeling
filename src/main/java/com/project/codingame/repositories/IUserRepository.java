package com.project.codingame.repositories;

import java.util.Optional;

import com.project.codingame.entities.User;

public interface IUserRepository extends CRUDRepository<User,String> {
    public Optional<User> findByName(String name); 
}
