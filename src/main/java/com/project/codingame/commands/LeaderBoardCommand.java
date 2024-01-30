package com.project.codingame.commands;

import java.util.List;

import com.project.codingame.entities.ScoreOrder;
import com.project.codingame.entities.User;
import com.project.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        ScoreOrder scoreOrder=ScoreOrder.valueOf(tokens.get(1));
            List<User> userList=userService.getAllUserScoreOrderWise(scoreOrder);
            System.out.println(userList);
    }
    
}
