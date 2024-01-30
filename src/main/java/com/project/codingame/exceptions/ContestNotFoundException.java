package com.project.codingame.exceptions;

public class ContestNotFoundException extends RuntimeException {
    public ContestNotFoundException()
    {
     super();
    }
    public ContestNotFoundException(String msg)
    {
     super(msg);
    }
}
