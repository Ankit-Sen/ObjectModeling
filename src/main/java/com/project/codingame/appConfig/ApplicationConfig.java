package com.project.codingame.appConfig;

import com.project.codingame.commands.AttendContestCommand;
import com.project.codingame.commands.CommandInvoker;
import com.project.codingame.commands.CreateContestCommand;
import com.project.codingame.commands.CreateQuestionCommand;
import com.project.codingame.commands.CreateUserCommand;
import com.project.codingame.commands.LeaderBoardCommand;
import com.project.codingame.commands.ListContestCommand;
import com.project.codingame.commands.ListQuestionCommand;
import com.project.codingame.commands.RunContestCommand;
import com.project.codingame.commands.WithdrawContestCommand;
import com.project.codingame.repositories.ContestRepository;
import com.project.codingame.repositories.IContestRepository;
import com.project.codingame.repositories.IQuestionRepository;
import com.project.codingame.repositories.IUserRepository;
import com.project.codingame.repositories.QuestionRepository;
import com.project.codingame.repositories.UserRepository;
import com.project.codingame.services.ContestService;
import com.project.codingame.services.IContestService;
import com.project.codingame.services.IQuestionService;
import com.project.codingame.services.IUserService;
import com.project.codingame.services.QuestionService;
import com.project.codingame.services.UserService;

public class ApplicationConfig {
    private final IQuestionRepository questionRepository = new QuestionRepository();
    private final IUserRepository userRepository = new UserRepository();
    private final IContestRepository contestRepository = new ContestRepository();

    private final IQuestionService questionService = new QuestionService(questionRepository);
    private final IUserService userService = new UserService(userRepository, contestRepository);
    private final IContestService contestService = new ContestService(contestRepository, questionRepository, userRepository, userService);
    
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final CreateQuestionCommand createQuestionCommand = new CreateQuestionCommand(questionService);
    private final ListQuestionCommand listQuestionCommand = new ListQuestionCommand(questionService);
    private final CreateContestCommand createContestCommand = new CreateContestCommand(contestService);
    private final ListContestCommand listContestCommand = new ListContestCommand(contestService);
    private final AttendContestCommand attendContestCommand = new AttendContestCommand(userService);
    private final RunContestCommand runContestCommand = new RunContestCommand(contestService);
    private final LeaderBoardCommand leaderBoardCommand = new LeaderBoardCommand(userService);
    private final WithdrawContestCommand withdrawContestCommand = new WithdrawContestCommand(userService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CREATE_USER",createUserCommand);
        commandInvoker.register("CREATE_QUESTION",createQuestionCommand);
        commandInvoker.register("LIST_QUESTION",listQuestionCommand);
        commandInvoker.register("CREATE_CONTEST",createContestCommand);
        commandInvoker.register("LIST_CONTEST",listContestCommand);
        commandInvoker.register("ATTEND_CONTEST",attendContestCommand);
        commandInvoker.register("RUN_CONTEST",runContestCommand);
        commandInvoker.register("LEADERBOARD",leaderBoardCommand);
        commandInvoker.register("WITHDRAW_CONTEST",withdrawContestCommand);
        return commandInvoker;
    }
}
