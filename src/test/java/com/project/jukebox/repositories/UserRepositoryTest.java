package com.project.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.project.jukebox.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        final Map<String,User> userMap = new HashMap<String,User>(){
            {
                put("1",new User("1", "user1"));
                put("2",new User("2", "user2"));
                put("3",new User("3", "user3"));
            }
        };
        userRepository = new UserRepository(userMap);
    }

    @Test
    @DisplayName("save method should create and return new User")
    public void saveUser(){
        //Arrange
        final User question4 = new User("4","user4");
        User expectedUser = new User("4", "user4");
        //Act
        User actualUser = userRepository.save(question4);
        //Assert
        Assertions.assertEquals(expectedUser,actualUser);
    }
    
    @Test
    @DisplayName("findById method should return User Given Id")
    public void findById_ShouldReturnUser_GivenUserId(){
        //Arrange
        String expectedUserId = "3";
        //Act
        User actualUser = userRepository.findById(expectedUserId);
        //Assert
        Assertions.assertEquals(expectedUserId,actualUser.getId());
    }

    @Test
    @DisplayName("findById method should return empty if User Not Found")
    public void findById_ShouldReturnEmptyIfUserNotFound(){
        //Arrange
        User expected = null;
        //Act
        User actual = userRepository.findById("5");
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("findByName method should return User Given Name")
    public void findByName_ShouldReturnUser_GivenUserId(){
        //Arrange
        String expectedUserName = "user1";
        //Act
        Optional<User> actualUser = userRepository.findByName(expectedUserName);
        //Assert
        Assertions.assertEquals(expectedUserName,actualUser.get().getName());
    }

    @Test
    @DisplayName("findByName method should return empty if User Not Found")
    public void findByName_ShouldReturnEmptyIfUserNotFound(){
        //Arrange
        Optional<User> expected = Optional.empty();
        //Act
        Optional<User> actual = userRepository.findByName("user5");
        //Assert
        Assertions.assertEquals(expected,actual);
    }
}
