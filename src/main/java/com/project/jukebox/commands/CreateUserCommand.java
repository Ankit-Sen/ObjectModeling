package com.project.jukebox.commands;

import java.util.List;
import com.project.jukebox.services.IUserService;

public class CreateUserCommand implements ICommand{

    IUserService userService;

    public CreateUserCommand(IUserService userService){
        this.userService=userService;
    }

    @Override
    public void execute(List<String> tokens) {
        String userName=tokens.get(1);
        System.out.println(userService.create(userName)); 
    }
    
}
