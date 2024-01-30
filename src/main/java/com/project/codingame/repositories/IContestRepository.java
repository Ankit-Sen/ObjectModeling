package com.project.codingame.repositories;

import java.util.List;

import com.project.codingame.entities.Contest;
import com.project.codingame.entities.Level;

public interface IContestRepository extends CRUDRepository<Contest,String> {
    public List<Contest> findAllContestLevelWise(Level level);
}
