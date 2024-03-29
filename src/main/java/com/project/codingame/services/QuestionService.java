package com.project.codingame.services;

import java.util.ArrayList;
import java.util.List;

import com.project.codingame.entities.Level;
import com.project.codingame.entities.Question;
import com.project.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
     final Question question = new Question(title,level, difficultyScore);
        return questionRepository.save(question);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        List<Question> listOfQuestions=new ArrayList<>();
        if(level!=null){
            listOfQuestions = questionRepository.findAllQuestionLevelWise(level);
            return listOfQuestions;
        }
        else{
            listOfQuestions = questionRepository.findAll();
            return listOfQuestions;
        }
    }
    
}
