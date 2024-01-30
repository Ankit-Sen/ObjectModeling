package com.project.codingame.services;

import java.util.List;

import com.project.codingame.entities.Level;
import com.project.codingame.entities.Question;

public interface IQuestionService {
    public Question create(String title, Level level, Integer difficultyScore);
    public List<Question> getAllQuestionLevelWise(Level level);
}
