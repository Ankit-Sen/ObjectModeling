package com.project.codingame.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException()
    {
     super();
    }
    public QuestionNotFoundException(String msg)
    {
     super(msg);
    }
}  
