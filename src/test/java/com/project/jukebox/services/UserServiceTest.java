package com.project.jukebox.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.project.jukebox.repositories.IUserRepository;
import com.project.jukebox.repositories.IPlaylistRepository;
import com.project.jukebox.entities.User;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;


@DisplayName("UserServiceTest")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @Mock
    private IPlaylistRepository playlistRepositoryMock;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("create method should create User")
    public void create_ShouldReturnUser(){
        //Arrange
        User expectedUser = new User("1", "Yakshit");
        when(userRepositoryMock.save(any(User.class))).thenReturn(expectedUser);

        //Act
        User actualUser = userService.create("Yakshit");

        //Assert
        Assertions.assertEquals(expectedUser,actualUser);
        verify(userRepositoryMock,times(1)).save(any(User.class));
    }

    
    @Test
    @DisplayName("getAll method should fetch All User")
    public void getAll_ShouldReturnAllUser(){

         //Arrange
         List<User> expectedUserList = new ArrayList<User>(){
            {
                add(new User("1", "1"));
                add(new User("2", "2"));
                add(new User("3", "3"));
            }
        };
        List<User> userList = new ArrayList<User>(){
            {
                add(new User("2", "2"));
                add(new User("1", "1"));
                add(new User("3", "3"));
            }
        };
        when(userRepositoryMock.findAll()).thenReturn(userList);
        //Act

        List<User> actualUserList = userService.getAllUsers();
        //Assert
        Assertions.assertEquals(expectedUserList, actualUserList);
        verify(userRepositoryMock,times(1)).findAll();
    }
    


    }

