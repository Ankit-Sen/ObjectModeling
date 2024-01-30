package com.project.codingame.services;

import java.util.List;

import com.project.codingame.dtos.UserRegistrationDto;
import com.project.codingame.entities.ScoreOrder;
import com.project.codingame.entities.User;
import com.project.codingame.exceptions.ContestNotFoundException;
import com.project.codingame.exceptions.InvalidOperationException;
import com.project.codingame.exceptions.UserNotFoundException;

public interface IUserService {
    public User create(String name);
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder);
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
}
