package com.project.jukebox.repositories;

import java.util.Optional;
import com.project.jukebox.entities.User;

public interface IUserRepository extends CRUDRepository<User,String> {

    public Optional<User> findByName(String name);
    
}
