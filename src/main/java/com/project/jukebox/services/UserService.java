package com.project.jukebox.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.project.jukebox.entities.User;
import com.project.jukebox.repositories.IUserRepository;

public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String name) {
        return userRepository.save(new User(name));
    }

    public List<User> getAllUsers(){
        List<User> list=userRepository.findAll();
        Collections.sort(list, new NameComparatorAsc());
        return list;
    }
    
}

class NameComparatorAsc implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Integer.compare((Integer.parseInt(u1.getId())), (Integer.parseInt(u2.getId())));
    }
}
