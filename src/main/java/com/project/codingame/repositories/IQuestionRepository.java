package com.project.codingame.repositories;

import java.util.List;

import com.project.codingame.entities.Level;
import com.project.codingame.entities.Question;

public interface IQuestionRepository extends CRUDRepository<Question,String> {
    public List<Question> findAllQuestionLevelWise(Level level);
}
