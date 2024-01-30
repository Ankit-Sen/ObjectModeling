package com.project.codingame.commands;

import java.util.List;
import com.project.codingame.entities.Level;
import com.project.codingame.exceptions.QuestionNotFoundException;
import com.project.codingame.exceptions.UserNotFoundException;
import com.project.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW","Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestName=tokens.get(1);
        try{
            if(tokens.size()<5){
                    System.out.println(contestService.create(contestName, Level.valueOf(tokens.get(2)), tokens.get(3), null)); 
                }else{
                    System.out.println(contestService.create(contestName, Level.valueOf(tokens.get(2)), tokens.get(3), Integer.parseInt(tokens.get(4)))); 
                }
        }catch(UserNotFoundException e){
            System.out.println(e.getMessage());
        }catch(QuestionNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
