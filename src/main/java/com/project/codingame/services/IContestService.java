package com.project.codingame.services;

import java.util.List;

import com.project.codingame.dtos.ContestSummaryDto;
import com.project.codingame.entities.Contest;
import com.project.codingame.entities.Level;
import com.project.codingame.exceptions.ContestNotFoundException;
import com.project.codingame.exceptions.InvalidContestException;
import com.project.codingame.exceptions.QuestionNotFoundException;
import com.project.codingame.exceptions.UserNotFoundException;

public interface IContestService {
    public Contest create(String contestName, Level level, String contestCreator, Integer numQuestion) throws UserNotFoundException, QuestionNotFoundException;
    public List<Contest> getAllContestLevelWise(Level level);
    public ContestSummaryDto runContest(String contestId, String contestCreator) throws ContestNotFoundException, InvalidContestException;
}
